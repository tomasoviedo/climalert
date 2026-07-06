package ar.edu.utn.frba.dds.repositories;

import ar.edu.utn.frba.dds.models.entities.Clima;

public interface ClimaRepository {
  public Void save(Clima clima);

  public Clima getLast();
}
