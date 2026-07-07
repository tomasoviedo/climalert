package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.config.RestWeatherProperties;
import ar.edu.utn.frba.dds.services.ClimaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class WeatherApplication {

  public static void main(String[] args) {
    SpringApplication.run(WeatherApplication.class, args);
  }

  //@Bean
  //public CommandLineRunner testearClima(ClimaService climaService) {
  //  return args -> climaService.guardarClima();
  //}
}
