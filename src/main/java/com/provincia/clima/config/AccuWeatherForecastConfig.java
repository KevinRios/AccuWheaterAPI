package com.provincia.clima.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccuWeatherForecastConfig {

    @Value("${accuweather.api.base-url}")
    private String baseUrl;

    @Value("${accuweather.api.key}")
    private String apiKey;

    @Value("${accuweather.api.forecast.path}")
    private String apiPath;

    @Value("${accuweather.api.forecast.metric}")
    private boolean metric;



    @Bean(name = "accuWeatherForecastProperties")
    public AccuWeatherProperties accuWeatherForecastProperties() {
        AccuWeatherProperties properties = new AccuWeatherProperties();
        properties.setBaseUrl(baseUrl);
        properties.setApiKey(apiKey);
        properties.setApiPath(apiPath);
        properties.setMetric(metric);
        return properties;
    }
}
