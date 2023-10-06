package com.provincia.clima.service;

import com.provincia.clima.model.CityInfoJSON;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class CityKeyService {
    private final RestTemplate restTemplate;
    private final String accuweatherBaseUrl;
    private final String accuweatherApiKey;

    public CityKeyService(RestTemplate restTemplate, @Value("${accuweather.api.base-url}") String accuweatherBaseUrl, @Value("${accuweather.api.key}") String accuweatherApiKey) {
        this.restTemplate = restTemplate;
        this.accuweatherBaseUrl = accuweatherBaseUrl;
        this.accuweatherApiKey = accuweatherApiKey;
    }

    public ResponseEntity<CityInfoJSON> getCityInfo(String cityName) {
        String url = accuweatherBaseUrl + "/locations/v1/cities/search";
        try {
            CityInfoJSON[] cityInfoJSONArray = restTemplate.getForObject(
                    url + "?q={cityName}&apikey={apiKey}",
                    CityInfoJSON[].class,
                    cityName,
                    accuweatherApiKey
            );

            if (cityInfoJSONArray != null && cityInfoJSONArray.length > 0) {
                return ResponseEntity.ok(cityInfoJSONArray[0]);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.status(e.getStatusCode()).build();
            }
        }
    }

    public String getCityKey(String cityName) {
        String url = accuweatherBaseUrl + "/locations/v1/cities/search";

        ResponseEntity<?> response = restTemplate.exchange(
                url + "?q={cityName}&apikey={apiKey}",
                HttpMethod.GET,
                null,
                String.class,
                cityName,
                accuweatherApiKey
        );

        String url2 = "ddd";

        //if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null && response.getBody().length > 0) {
       //     return response.getBody()[0].getKey();
     //  }
        return null;
    }
}
