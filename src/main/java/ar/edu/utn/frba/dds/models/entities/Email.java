package ar.edu.utn.frba.dds.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Data
@AllArgsConstructor
public class Email {
  private String remitente;
  private String destionatario;
  private String asunto;
  private String contenido;


}
