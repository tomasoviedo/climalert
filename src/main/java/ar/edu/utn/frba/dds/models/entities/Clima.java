package ar.edu.utn.frba.dds.models.entities;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Clima {
  private Double temperatura;
  private Double humedad;
  private LocalDateTime fechaRegistro;
  private String pais;
  private String region;
  private String ciudad;

  public Clima() {
    fechaRegistro = LocalDateTime.now();
  }
}
