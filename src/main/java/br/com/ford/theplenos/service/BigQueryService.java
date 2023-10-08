package br.com.ford.theplenos.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.auth.oauth2.GoogleCredentials;
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

@Service
public class BigQueryService {

	private final BigQueryAppProperties properties;
	private final RestTemplate restTemplate;
	private final ObjectMapper objectMapper = new ObjectMapper();

	public BigQueryService(BigQueryAppProperties properties, RestTemplate restTemplate) {
		this.properties = properties;
		this.restTemplate = restTemplate;
	}

	private GoogleCredentials getCredentialsFromPublicLink() throws IOException {
		String credentialsUrl = "https://storage.googleapis.com/fordfuel.appspot.com/credentials.properties";
		byte[] content = restTemplate.getForObject(credentialsUrl, byte[].class);
		try (ByteArrayInputStream byteArrayStream = new ByteArrayInputStream(content)) {
			return GoogleCredentials.fromStream(byteArrayStream);
		}
	}

	public List<ObjectNode> findAllAbastecimento() throws BigQuerySearchException {
		BigQuery bigquery;

		try {
			GoogleCredentials credentials = getCredentialsFromPublicLink();

			bigquery = BigQueryOptions
					.newBuilder()
					.setProjectId(properties.getProjectId())
					.setCredentials(credentials)
					.build().getService();
		} catch (IOException ex) {
			throw new BigQuerySearchException("IO Exception thrown - can't find google credentials file", ex);
		}

		final QueryJobConfiguration queryConfig = QueryJobConfiguration.newBuilder("SELECT * FROM ford.Cliente order by 1 desc").setUseLegacySql(true).build();

		Job queryJob = bigquery.create(JobInfo.of(queryConfig)); 

		try {
			queryJob = queryJob.waitFor();

			if (queryJob == null) {
				throw new BigQuerySearchException("Job no longer exists");
			} else if (queryJob.getStatus().getError() != null) {
				throw new BigQuerySearchException(queryJob.getStatus().getError().toString());
			}

			final TableResult result = queryJob.getQueryResults();

			final List<String> fieldList = result.getSchema()
					.getFields()
					.stream()
					.map(Field::getName)
					.collect(Collectors.toList());

			return tableResultToJSONStringListConverter(result, fieldList);
		} catch (InterruptedException ex) {
			throw new BigQuerySearchException("InterruptedException - query job failed", ex);
		}
	}

	private List<ObjectNode> tableResultToJSONStringListConverter(TableResult result, List<String> fields) {
		final List<ObjectNode> queryList = new ArrayList<>();

		for (FieldValueList row : result.iterateAll()) {
			final ObjectNode jsonObject = objectMapper.createObjectNode();

			fields.forEach(field -> jsonObject.put(field, row.get(field).getStringValue()));

			queryList.add(jsonObject);
		}

		return queryList;
	}
}
