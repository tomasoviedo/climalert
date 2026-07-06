package ar.edu.utn.frba.dds.models.entities;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Clima {
    private Long id;
    private Double temperatura;
    private Double humedad;
    private LocalDateTime fechaRegistro;
    private String pais;
    private String region;
    private String ciudad;

    public Clima(){
        fechaRegistro = LocalDateTime.now();

    }
}
