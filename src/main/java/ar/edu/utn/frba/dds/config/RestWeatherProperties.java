package ar.edu.utn.frba.dds.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "weather-api")
@Data
public class RestWeatherProperties {

  private String baseUrl;
  private String apiKey;
  private String location;
}
