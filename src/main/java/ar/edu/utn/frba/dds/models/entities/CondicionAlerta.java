package ar.edu.utn.frba.dds.models.entities;

import ar.edu.utn.frba.dds.models.entities.Clima;

public interface CondicionAlerta {
    boolean cumple(Clima clima);
}