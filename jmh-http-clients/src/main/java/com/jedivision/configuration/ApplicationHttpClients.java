package com.jedivision.configuration;

import okhttp3.OkHttpClient;
import org.apache.commons.httpclient.HttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

@Configuration
public class ApplicationHttpClients {

    @Bean
    public Client client() {
        return ClientBuilder.newClient();
    }

    @Bean
    public HttpClient httpClient() {
        return new HttpClient();
    }

    @Bean
    public OkHttpClient okHttp() {
        return new OkHttpClient();
    }
}
