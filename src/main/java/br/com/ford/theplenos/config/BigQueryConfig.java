package br.com.ford.theplenos.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class BigQueryConfig {

    @Bean
    public BigQuery bigQuery() throws IOException {
        // Carrega as credenciais do arquivo JSON
        GoogleCredentials credentials = GoogleCredentials.fromStream(
                getClass().getClassLoader().getResourceAsStream("path/to/your/credentials.json"));

        return BigQueryOptions.newBuilder()
                .setCredentials(credentials)
                .build()
                .getService();
    }
}
