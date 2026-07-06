package ar.edu.utn.frba.dds.services.impl;

import ar.edu.utn.frba.dds.config.RestWeatherProperties;
import ar.edu.utn.frba.dds.models.entities.Clima;
import ar.edu.utn.frba.dds.repositories.ClimaRepository;
import ar.edu.utn.frba.dds.services.ClimaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
@AllArgsConstructor
public class ClimaServiceImpl implements ClimaService {

    private RestWeatherProperties properties;
    private RestTemplate restTemplate;
    private ClimaRepository climaRepository;

    @Override
    public String obtenerClima() {
        Clima climaActual = obtenerClimaActual();
        climaRepository.save(climaActual);
        return null;
    }

    private Clima obtenerClimaActual() {
        URI uri =
                UriComponentsBuilder.fromUriString(properties.getBaseUrl())
                        .queryParam("key", properties.getApiKey())
                        .queryParam("q", "CABA  ")
                        .queryParam("aqi", "no")
                        .build()
                        .toUri();
        return restTemplate.getForObject(uri, Clima.class);
    }
}
