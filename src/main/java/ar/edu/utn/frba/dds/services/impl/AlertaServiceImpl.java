package ar.edu.utn.frba.dds.services.impl;

import ar.edu.utn.frba.dds.models.entities.Alerta;
import ar.edu.utn.frba.dds.models.entities.Clima;
import ar.edu.utn.frba.dds.models.entities.GeneradorAlertas;
import ar.edu.utn.frba.dds.repositories.ClimaRepository;
import ar.edu.utn.frba.dds.services.AlertaService;
import ar.edu.utn.frba.dds.services.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AlertaServiceImpl implements AlertaService {
  private ClimaRepository repository;
  private GeneradorAlertas generador;
  private EmailService emailService;

  @Override
  public void analizarClima() {
    Clima clima = repository.getLast();
    Alerta alerta = generador.evaluarClima(clima);
    if (alerta != null) {
      emailService.enviarAlerta(alerta);
      
    }
  }
}
