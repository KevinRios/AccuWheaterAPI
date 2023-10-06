package com.provincia.clima.controllers;

import com.provincia.clima.dtos.ClimaRequest;
import com.provincia.clima.dtos.ClimaResponse;
import com.provincia.clima.service.ClimaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/clima")
public class ClimaController {

    @Autowired
    private ClimaService climaService;

    @PostMapping("/search-and-save")
    public ResponseEntity<ClimaResponse> searchAndSaveClima(@RequestBody ClimaRequest request) {
        ClimaResponse response = climaService.searchAndSaveClima(request);
        return ResponseEntity.ok(response);
    }

}
