package com.provincia.clima.config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccuWeatherProperties {

    //campos generales
    private String baseUrl;
    private String apiKey;
    private String apiPath;


    // campos para Forecast endpoint
    private boolean metric;

}
