package com.provincia.clima.service;

import com.provincia.clima.dtos.ClimaRequest;
import com.provincia.clima.dtos.ClimaResponse;
import com.provincia.clima.interfaces.IClimaDataService;
import com.provincia.clima.model.CityInfoJSON;
import com.provincia.clima.model.ClimaHourlyJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClimaService implements IClimaDataService {

    @Autowired
    private AccuWeatherLocationService accuWeatherLocationService;
    @Autowired
    private AccuWeatherForecastService accuWeatherForecastService;
    @Autowired
    private ClimaPersistenceService climaPersistenceService;

    @Override
    public ClimaResponse searchAndSaveClima(ClimaRequest request) {
        String cityName = request.getCityName();

        if (cityName != null) {
            // Paso 1: Obtener el cityKey
            List<CityInfoJSON> cityInfoList = accuWeatherLocationService.getCityKey(cityName);

            if (!cityInfoList.isEmpty()) {
                // para simplificar el uso de la API, solo voy a usar el primer elemento que trae la consulta a la API de locations
                CityInfoJSON cityInfo = cityInfoList.get(0);

                // Paso 2: Obtener los datos del clima usando el cityKey
                List<ClimaHourlyJSON> hourlyForecast = accuWeatherForecastService.getHourlyForecast(cityInfo.getKey());

                if (!hourlyForecast.isEmpty()) {
                    // Paso 3: Configurar el cityName en cada instancia de ClimaHourlyJSON
                    for (ClimaHourlyJSON climaHourly : hourlyForecast) {
                        climaHourly.setCityName(cityName);
                    }

                    // Paso 4: Guardar los datos en la base de datos
                    climaPersistenceService.saveClimaEntity(hourlyForecast);


                    // Respuesta
                    return new ClimaResponse("Datos guardados correctamente: ", hourlyForecast);
                }
            }
        }
        return new ClimaResponse("No se encontraron datos o hubo un problema", null);
    }
}