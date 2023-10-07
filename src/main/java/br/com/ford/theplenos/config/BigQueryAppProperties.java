package br.com.ford.theplenos.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ComponentScan
@ConfigurationProperties(prefix = "br.com.ford.theplenos")
public class BigQueryAppProperties {

    private String credentialsPath = "resources";
    private String credientalsName = "fordfuel-0b5e12e3cf53.json";
    private String projectId = "fordfuel";

}
