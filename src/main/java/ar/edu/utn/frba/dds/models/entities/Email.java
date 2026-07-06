package ar.edu.utn.frba.dds.models.entities;

import lombok.Setter;

public class Email {
    @Setter
    private Long id;
    private String remitente;
    private String destionatario;
    private String asunto;
    private String contenido;

    public Email(String remitente,String destinatario, String asunto,String contenido)
    {
        this.remitente=remitente;
        this.destionatario =destinatario;
        this.asunto=asunto;
        this.contenido=contenido;
    }
}

