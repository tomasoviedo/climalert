package ar.edu.utn.frba.dds.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Current(
    @JsonProperty("temp_c") Double tempC, @JsonProperty("humidity") Integer humidity) {}
