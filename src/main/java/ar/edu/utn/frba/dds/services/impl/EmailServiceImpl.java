package ar.edu.utn.frba.dds.services.impl;

import ar.edu.utn.frba.dds.models.entities.Alerta;
import ar.edu.utn.frba.dds.services.EmailService;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
  @Override
  public Void enviarAlerta(Alerta alerta) {
    return null;
  }
}
