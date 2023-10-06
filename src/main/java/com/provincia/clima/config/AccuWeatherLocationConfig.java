package com.provincia.clima.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccuWeatherLocationConfig {

    @Value("${accuweather.api.base-url}")
    private String baseUrl;

    @Value("${accuweather.api.key}")
    private String apiKey;

    @Value("${accuweather.api.location.path}")
    private String apiPath;

    @Bean(name = "accuWeatherLocationProperties")
    public AccuWeatherProperties accuWeatherLocationProperties() {
        AccuWeatherProperties properties = new AccuWeatherProperties();
        properties.setBaseUrl(baseUrl);
        properties.setApiKey(apiKey);
        properties.setApiPath(apiPath);
        return properties;
    }
}
