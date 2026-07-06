package ar.edu.utn.frba.dds.models.entities;

import lombok.Data;

@Data
public class Alerta {
  private Clima clima;
  private String detalle;
}
