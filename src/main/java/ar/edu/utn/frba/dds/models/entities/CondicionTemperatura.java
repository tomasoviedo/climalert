package ar.edu.utn.frba.dds.models.entities;

import ar.edu.utn.frba.dds.models.entities.Clima;
import org.springframework.stereotype.Component;

@Component
public class CondicionTemperatura implements CondicionAlerta {
    private static final double UMBRAL_TEMPERATURA = 35.0;

    @Override
    public boolean cumple(Clima clima) {
        return clima.getTemperatura() > UMBRAL_TEMPERATURA;
    }
}
