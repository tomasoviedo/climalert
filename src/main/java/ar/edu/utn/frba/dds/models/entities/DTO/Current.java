package ar.edu.utn.frba.dds.models.entities.DTO;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Current {
    @JsonProperty("temp_c")
    private Double tempC;

    @JsonProperty("humidity")
    private Integer humidity;
}