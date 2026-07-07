package ar.edu.utn.frba.dds.scheduler;

import ar.edu.utn.frba.dds.services.ClimaService;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ClimaScheduler {

  private final ClimaService climaService;

  @Scheduled(cron = "0 */5 * * * *", zone = "America/Argentina/Buenos_Aires")
  public void obtenerClima() {
    System.out.print("cron corriendo");
    climaService.guardarClima();
  }
}
