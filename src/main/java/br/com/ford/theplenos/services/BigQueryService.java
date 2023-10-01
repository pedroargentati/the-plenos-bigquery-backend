package br.com.ford.theplenos.services;

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.JobException;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.TableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BigQueryService {

    @Autowired
    private BigQuery bigQuery;

    public TableResult runQuery(String query) throws JobException, InterruptedException {
        QueryJobConfiguration queryConfig = QueryJobConfiguration.newBuilder(query).build();
        return bigQuery.query(queryConfig);
    }
}
