package ar.edu.utn.frba.dds.scheduler;

import ar.edu.utn.frba.dds.models.entities.Alerta;
import ar.edu.utn.frba.dds.services.AlertaService;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AlertaScheduler {
  private AlertaService alertaService;

  @Scheduled(cron = "0 /5 * * * *", zone = "America/Argentina/Buenos_Aires")
  public void obtenerClima() {
    Alerta alerta = alertaService.analizarClima();
  }
}
