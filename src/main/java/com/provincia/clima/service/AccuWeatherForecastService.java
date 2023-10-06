    package com.provincia.clima.service;

    import com.provincia.clima.config.AccuWeatherProperties;
    import com.provincia.clima.interfaces.IClima;
    import com.provincia.clima.model.ClimaHourlyJSON;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.beans.factory.annotation.Qualifier;
    import org.springframework.http.HttpMethod;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.stereotype.Service;
    import org.springframework.web.client.RestTemplate;
    import org.springframework.web.util.UriComponentsBuilder;

    import java.net.URI;
    import java.util.Arrays;
    import java.util.Collections;
    import java.util.List;

    @Service
    public class AccuWeatherForecastService implements IClima {

        @Autowired
        private RestTemplate restTemplate;

        @Autowired
        @Qualifier("accuWeatherForecastProperties")
        private AccuWeatherProperties accuWeatherProperties;


        // Implementación para obtener los datos del clima por hora
        @Override
        public List<ClimaHourlyJSON> getHourlyForecast(String cityKey) {
            String url = accuWeatherProperties.getBaseUrl() + accuWeatherProperties.getApiPath();

            UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url)
                    .queryParam("apikey", accuWeatherProperties.getApiKey())
                    .queryParam("metric", accuWeatherProperties.isMetric());

            URI uri = uriBuilder.buildAndExpand(cityKey).toUri();

            ResponseEntity<ClimaHourlyJSON[]> response = restTemplate.exchange(
                    uri,
                    HttpMethod.GET,
                    null,
                    ClimaHourlyJSON[].class
            );

            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
                return Arrays.asList(response.getBody());
            } else {
                return Collections.emptyList();
            }
        }
    }
