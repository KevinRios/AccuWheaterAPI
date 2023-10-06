package com.provincia.clima.service;

import com.provincia.clima.config.AccuWeatherProperties;
import com.provincia.clima.interfaces.ICityKey;
import com.provincia.clima.model.CityInfoJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.List;

@Service
public class AccuWeatherLocationService implements ICityKey {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    @Qualifier("accuWeatherLocationProperties")
    private AccuWeatherProperties accuWeatherProperties;

    // Implementación para obtener la key de una ciudad -> esta key la necesito para buscar los datos del clima de esa ciudad
    @Override
    public List<CityInfoJSON> getCityKey(String cityName) {

        String url = accuWeatherProperties.getBaseUrl() + accuWeatherProperties.getApiPath();

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("apikey", accuWeatherProperties.getApiKey())
                .queryParam("q", cityName);;

        URI uri = uriBuilder.buildAndExpand(cityName).toUri();
        ResponseEntity<CityInfoJSON[]> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                null,
                CityInfoJSON[].class
        );

        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
            CityInfoJSON[] cityInfoArray = response.getBody();
            if (cityInfoArray.length > 0) {
                // Devuelve una lista con un solo elemento el primer elemento de la lista original
                return Collections.singletonList(cityInfoArray[0]);
            }
        }

        // Si no se encontraron resultados o hubo un error, devuelvo una lista vacía
        return Collections.emptyList();
    }
}
