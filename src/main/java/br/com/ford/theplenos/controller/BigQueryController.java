package br.com.ford.theplenos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.google.cloud.bigquery.JobException;
import com.google.cloud.bigquery.TableResult;

import br.com.ford.theplenos.services.BigQueryService;

@RestController
public class BigQueryController {

    @Autowired
    private BigQueryService bigQueryService;

    @GetMapping("/query/{sql}")
    public TableResult executeQuery(@PathVariable("sql") String sql) throws JobException, InterruptedException {
        return bigQueryService.runQuery(sql);
    }
}
