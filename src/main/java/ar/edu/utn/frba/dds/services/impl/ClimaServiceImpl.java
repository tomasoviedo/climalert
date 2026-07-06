package ar.edu.utn.frba.dds.services.impl;

import ar.edu.utn.frba.dds.config.RestWeatherProperties;
import ar.edu.utn.frba.dds.models.dto.ClimaRespuesta;
import ar.edu.utn.frba.dds.models.entities.Clima;
import ar.edu.utn.frba.dds.repositories.ClimaRepository;
import ar.edu.utn.frba.dds.services.ClimaService;
import java.net.URI;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@Service
@AllArgsConstructor
public class ClimaServiceImpl implements ClimaService {

  private RestWeatherProperties properties;
  private RestTemplate restTemplate;
  private ClimaRepository climaRepository;

  @Override
  public Clima guardarClima() {
    ClimaRespuesta res = this.obtenerClimaActual();
    log.info("Respuesta WeatherAPI: {}", res);

    Clima clima = new Clima();
    clima.setTemperatura(res.current().tempC());
    clima.setHumedad(Double.valueOf(res.current().humidity()));
    clima.setCiudad(res.location().name());
    clima.setPais(res.location().country());
    clima.setRegion(res.location().region());

    climaRepository.save(clima);
    log.info("Clima guardado: {}", clima);
    return clima;
  }

  private ClimaRespuesta obtenerClimaActual() {
    URI uri =
        UriComponentsBuilder.fromUriString(properties.getBaseUrl())
            .queryParam("key", properties.getApiKey())
            .queryParam("q", properties.getLocation())
            .queryParam("aqi", "no")
            .build()
            .toUri();
    return restTemplate.getForObject(uri, ClimaRespuesta.class);
  }
}
