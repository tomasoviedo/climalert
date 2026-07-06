package ar.edu.utn.frba.dds.repositories;

import ar.edu.utn.frba.dds.models.entities.Clima;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class ClimaRepositoryInMemory implements ClimaRepository {
  private List<Clima> climas = new ArrayList<>();

  @Override
  public Void save(Clima clima) {
    climas.add(clima);
    return null;
  }

  @Override
  public Clima getLast() {
    return climas.getLast();
  }
}
