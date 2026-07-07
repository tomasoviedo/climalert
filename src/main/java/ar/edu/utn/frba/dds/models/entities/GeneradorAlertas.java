package ar.edu.utn.frba.dds.models.entities;

import ar.edu.utn.frba.dds.models.entities.CondicionAlerta;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class GeneradorAlertas {

  private final List<CondicionAlerta> condiciones;

  public Alerta evaluarClima(Clima clima) {
    boolean disparaAlerta = condiciones.stream().allMatch(c -> c.cumple(clima));

    if (disparaAlerta) {
      Alerta alerta = new Alerta();
      alerta.setClima(clima);
      alerta.setDetalle(construirDetalle(clima));
      return alerta;
    }
    return null;
  }

  private String construirDetalle(Clima clima) {
    return String.format(
            "ALERTA en %s: Temperatura: %.1f°C; Humedad: %.1f%%.",
            clima.getCiudad(), clima.getTemperatura(), clima.getHumedad());
  }
}