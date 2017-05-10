package com.jedivision.configuration;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationHttpClients {

    @Bean
    public OkHttpClient okHttp() {
        return new OkHttpClient();
    }
}
