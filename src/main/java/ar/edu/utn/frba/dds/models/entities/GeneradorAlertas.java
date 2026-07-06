package ar.edu.utn.frba.dds.models.entities;

import org.springframework.stereotype.Component;

@Component
public class GeneradorAlertas {
  private Icono icono;

  public Alerta evaluarClima(Clima clima) {
    if (this.cumpleCondicion(clima)) {
      Alerta alerta = new Alerta();
      alerta.setClima(clima);
      String detalle =
          icono.texto()
              + String.format(
                  "ALERTA en %s: Temperatura: %.1f°C; Humedad: %1f%%.",
                  clima.getCiudad(), clima.getTemperatura(), clima.getHumedad());
      alerta.setDetalle(detalle);
      return alerta;
    }
    return null;
  }

  private Boolean cumpleCondicion(Clima clima) {
    return clima.getTemperatura() > 35.0 && clima.getHumedad() > 60;
  }
}
