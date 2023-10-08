package br.com.ford.theplenos.service.utility;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.auth.oauth2.GoogleCredentials;

//@Service
public class GoogleCredentialsUtility {
//
//    @Bean
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }
//
//    @Bean
//    public GoogleCredentials googleCredentials(RestTemplate restTemplate) throws IOException {
//        String credentialsUrl = "https://storage.googleapis.com/fordfuel.appspot.com/credentials.properties";
//        byte[] content = restTemplate.getForObject(credentialsUrl, byte[].class);
//        try (ByteArrayInputStream byteArrayStream = new ByteArrayInputStream(content)) {
//            return GoogleCredentials.fromStream(byteArrayStream);
//        }
//    }
}