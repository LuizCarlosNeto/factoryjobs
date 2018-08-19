package br.com.luiz.factoryjobs.app.jobs.example;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import br.com.luiz.factoryjobs.app.jobs.FactoryJob;

@Component
public class LoggingJob implements FactoryJob{

	private final Logger log = LoggerFactory.getLogger(LoggingJob.class);
 	private final SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss");
	
 	
 	@Override
 	public void run() {
 		System.out.println("teste de execução: execucaoJob");
 		log.info("Hora atual: {}", fmt.format(new Date()));
 	}
 
 	@Override
 	public String getJobName() {
 		return "Exemplo";
 	}
}
	
