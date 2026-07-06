package ar.edu.utn.frba.dds.models.entities.DTO;

import lombok.Data;

@Data
public class Location {
    private String name;
    private String region;
    private String country;
    private Double lat;
    private Double lon;
}