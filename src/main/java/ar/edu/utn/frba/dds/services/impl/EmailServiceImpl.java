package ar.edu.utn.frba.dds.services.impl;

import ar.edu.utn.frba.dds.config.EmailProperties;
import ar.edu.utn.frba.dds.models.entities.Alerta;
import ar.edu.utn.frba.dds.services.EmailService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmailServiceImpl implements EmailService {
  private final JavaMailSender mailSender;
  private final EmailProperties emailProperties;



  @Override
  public void enviarAlerta(Alerta alerta) {
    List<String> destinatarios = emailProperties.getDestinatarios();

    System.out.println("Recibí el evento de alerta. Enviando mails");

    for (String d : destinatarios) {
      mailSender.send(this.armarMail(d, alerta));
      System.out.println("Enviando mail, destinatario: " + d);
    }

  }
    private SimpleMailMessage armarMail(String destinatario, Alerta alerta){
      SimpleMailMessage mensaje = new SimpleMailMessage();
      String body = alerta.getDetalle();

      mensaje.setFrom("${spring.mail.username}");
      mensaje.setTo(destinatario);
      mensaje.setSubject("CLIMALERT");
      mensaje.setText(body);

      return mensaje;
    }
  }

