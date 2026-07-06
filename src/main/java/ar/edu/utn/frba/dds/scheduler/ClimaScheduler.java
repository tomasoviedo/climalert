package ar.edu.utn.frba.dds.scheduler;

import ar.edu.utn.frba.dds.services.ClimaService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ClimaScheduler {

    private final ClimaService climaService;

    public ClimaScheduler(ClimaService climaService){
        this.climaService = climaService;
    }

    @Scheduled(cron = "0 /5 * * * *", zone = "America/Argentina/Buenos_Aires")
    public void obtenerClima(){
        climaService.obtenerClima();
    }
}
