package com.provincia.clima.interfaces;

import com.provincia.clima.dtos.ClimaRequest;
import com.provincia.clima.dtos.ClimaResponse;

public interface IClimaDataService {

    ClimaResponse searchAndSaveClima(ClimaRequest request);

}
