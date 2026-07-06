package ar.edu.utn.frba.dds.repositories;

import ar.edu.utn.frba.dds.models.entities.Clima;
import org.springframework.stereotype.Repository;

@Repository
public class ClimaRepositoryInMemory implements ClimaRepository {

    @Override
    public Void save(Clima clima){
        return null;
    }
}
