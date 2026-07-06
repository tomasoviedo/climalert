package ar.edu.utn.frba.dds.services.impl;

import ar.edu.utn.frba.dds.config.RestWeatherProperties;
import ar.edu.utn.frba.dds.models.entities.Clima;
import ar.edu.utn.frba.dds.models.entities.DTO.ClimaRespuesta;
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
    public Clima guardarClima() {
        ClimaRespuesta res = this.obtenerClimaActual();
        Clima clima = new Clima();
        clima.setTemperatura(res.getCurrent().getTempC());
        clima.setHumedad(Double.valueOf(res.getCurrent().getHumidity()));
        clima.setCiudad(res.getLocation().getName());
        clima.setPais(res.getLocation().getCountry());
        clima.setRegion(res.getLocation().getRegion());

        climaRepository.save(clima);
        return clima;
    }

    private ClimaRespuesta obtenerClimaActual() {
        URI uri =
                UriComponentsBuilder.fromUriString(properties.getBaseUrl())
                        .queryParam("key", properties.getApiKey())
                        .queryParam("q", "CABA")
                        .queryParam("aqi", "no")
                        .build()
                        .toUri();
        return restTemplate.getForObject(uri, ClimaRespuesta.class);
    }
}
