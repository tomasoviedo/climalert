package ar.edu.utn.frba.dds.models.entities;

import ar.edu.utn.frba.dds.models.entities.Clima;
import org.springframework.stereotype.Component;

@Component
public class CondicionHumedad implements CondicionAlerta {
    private static final double UMBRAL_HUMEDAD = 60.0;

    @Override
    public boolean cumple(Clima clima) {
        return clima.getHumedad() > UMBRAL_HUMEDAD;
    }
}