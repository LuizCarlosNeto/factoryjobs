package br.com.luiz.factoryjobs.app.jobs;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
public class Rotinas {

private final Logger log = LoggerFactory.getLogger(Rotinas.class);
 	
 	
 	@Autowired
 	@Qualifier("jobsDiarios")
 	private List<FactoryJob> jobsDiarios = new ArrayList<>();
 	
 	@Autowired
 	@Qualifier("jobsContinuos")
 	private List<FactoryJob> jobsContinuos = new ArrayList<>();
 	
 	
 	@Scheduled(cron="0 0 12 * * *")
 	public void runJobsDiarios() {
 		try {
 			log.info("#########################################################");
 			log.info("Execução dos Jobs Diários Iniciada!");
 			for(FactoryJob job : jobsDiarios) {
 				try {
 					log.info("Executando o job: {} - ({})", job.getJobName().toString() , job.getClass().getCanonicalName());
 					job.run();
 					//TODO cadastrar sucesso!
 				} catch(Exception e) {
 					log.error(e.getMessage(), e);
 					//TODO cadastrar erro!
 				}
 			}
 		} catch (Exception e) {
 			log.error(e.getMessage(), e);
 		}
 	}
 	
 	@Scheduled(cron="*/10 * * * * *")
 	public void runJobsContinuos() {
 		try {
 			log.info("Execução dos Jobs Contínuos Iniciada!");
 			for(FactoryJob job : jobsContinuos) {
 				try {
 					log.info("Executando o job: {} - ({})", job.getJobName(), job.getClass().getCanonicalName());
 					job.run();
 					//TODO cadastrar sucesso!
 				} catch(Exception e) {
 					log.error(e.getMessage(), e);
 					//TODO cadastrar erro!
 				}
 			}
 		} catch (Exception e) {
 			log.error(e.getMessage(), e);
 		}
 	}
}
