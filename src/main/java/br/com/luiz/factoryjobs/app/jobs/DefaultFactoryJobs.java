package br.com.luiz.factoryjobs.app.jobs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.luiz.factoryjobs.app.jobs.example.LoggingJob;

@Configuration
public class DefaultFactoryJobs {
	
	@Autowired private LoggingJob loggingJob;

	/*
	 * Método responsável por injetar a lista de jobs diarios na classe FactoryJob
	 */
	@Bean("jobsDiarios")
	public List<FactoryJob> getJobsDiarios() {
		List<FactoryJob> jobsDiarios = new ArrayList<>();
		jobsDiarios.add(loggingJob);
		return jobsDiarios;
	}
	
	/*
	 * Método responsável por injetar a lista de jobs continuos na classe FactoryJob
	 */
	@Bean(name="jobsContinuos")
	public List<FactoryJob> getJobsContinuos() {
		List<FactoryJob> jobsContinuos = new ArrayList<>();
		jobsContinuos.add(loggingJob);
		return jobsContinuos;
	}
}

