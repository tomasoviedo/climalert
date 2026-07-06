package ar.edu.utn.frba.dds.models.entities.DTO;

import lombok.Data;

@Data
public class ClimaRespuesta  {
    private Location location;
    private Current current;
}