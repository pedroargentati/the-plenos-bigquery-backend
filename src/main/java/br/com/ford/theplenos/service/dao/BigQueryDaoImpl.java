package br.com.ford.theplenos.service.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.FieldValueList;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobInfo;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.TableResult;

import br.com.ford.theplenos.config.BigQueryAppProperties;
import br.com.ford.theplenos.exception.BigQuerySearchException;
import br.com.ford.theplenos.service.utility.GoogleCredentialsUtility;

public class BigQueryDaoImpl<T> implements BigQueryDao<T> {

    private final BigQueryAppProperties properties;
    private final ObjectMapper objectMapper = new ObjectMapper();

    private final Class<T> type;

    public BigQueryDaoImpl(BigQueryAppProperties properties, Class<T> type) {
        this.properties = properties;
        this.type = type;
    }

    @Override
    public List<T> findAll() throws BigQuerySearchException {
        List<ObjectNode> jsonList = findJsonResults("SELECT * FROM ford." + this.resolveTableName() + " order by 1 desc");
        return jsonList.stream()
            .map(json -> objectMapper.convertValue(json, type))
            .collect(Collectors.toList());
    }

    private List<ObjectNode> findJsonResults(String query) throws BigQuerySearchException {
        BigQuery bigquery = createBigQueryClient();
        
        final QueryJobConfiguration queryConfig = QueryJobConfiguration
            .newBuilder(query)
            .setUseLegacySql(true)
            .build();

        Job queryJob = bigquery.create(JobInfo.of(queryConfig));

        try {
            queryJob = queryJob.waitFor();
            handleJobErrors(queryJob);
            final TableResult result = queryJob.getQueryResults();
            return convertTableResultToJsonList(result);
        } catch (InterruptedException ex) {
            throw new BigQuerySearchException("InterruptedException - query job failed", ex);
        }
    }

    private BigQuery createBigQueryClient() throws BigQuerySearchException {
        try {
            return BigQueryOptions.newBuilder()
                .setProjectId(properties.getProjectId())
                .setCredentials(GoogleCredentialsUtility.getCreds(properties.getCredentialsPath(), properties.getCredientalsName()))
                .build()
                .getService();
        } catch (IOException ex) {
            throw new BigQuerySearchException("IO Exception thrown - can't find google credentials file", ex);
        }
    }

    private void handleJobErrors(Job job) throws BigQuerySearchException {
        if (job == null) {
            throw new BigQuerySearchException("Job no longer exists");
        } else if (job.getStatus().getError() != null) {
            throw new BigQuerySearchException(job.getStatus().getError().toString());
        }
    }
    
    private String resolveTableName() {
        String simpleName = type.getSimpleName();
        if (simpleName.endsWith("Entity")) {
            return simpleName.substring(0, simpleName.length() - "Entity".length());
        }
        return simpleName;
    }

    
    private List<ObjectNode> convertTableResultToJsonList(TableResult result) {
        final List<String> fieldList = result.getSchema().getFields().stream().map(Field::getName).collect(Collectors.toList());
        List<ObjectNode> jsonList = new ArrayList<>();
        for (FieldValueList row : result.iterateAll()) {
            ObjectNode jsonObject = objectMapper.createObjectNode();
            fieldList.forEach(field -> jsonObject.put(field, row.get(field).getStringValue()));
            jsonList.add(jsonObject);
        }
        return jsonList;
    }
}
