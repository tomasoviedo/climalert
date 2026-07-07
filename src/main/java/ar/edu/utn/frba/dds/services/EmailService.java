package ar.edu.utn.frba.dds.services;

import ar.edu.utn.frba.dds.models.entities.Alerta;

public interface EmailService {
  public void enviarAlerta(Alerta alerta);
}
