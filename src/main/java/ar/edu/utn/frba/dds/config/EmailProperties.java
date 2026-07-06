package ar.edu.utn.frba.dds.config;

import java.util.List;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component

@ConfigurationProperties(prefix = "alerta")
@Data
public class EmailProperties {

    private List<String> destinatarios;

}