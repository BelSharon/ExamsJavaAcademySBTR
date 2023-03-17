package com.curso.sbatch.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tareas")
public class TareaController {

    @Autowired
    //inyección de trigger (jobLauncher)
    private JobLauncher jobLauncher;
    @Autowired
    private Job tarea;

    @PostMapping("/importClientes")
    public void importCsvToDBJob() {
    	
    	long horaInicio = System.currentTimeMillis();
    	
    	//asigna paramentros a la tarea
        JobParameters jobParameters = new JobParametersBuilder()
            .addLong("startAt",horaInicio).toJobParameters();
        
        try {
        	//aqui se dispara el proceso
            jobLauncher.run(tarea, jobParameters);
            //usa multicatch
        } catch (JobExecutionAlreadyRunningException | 
        		JobRestartException | 
        		JobInstanceAlreadyCompleteException | 
        		JobParametersInvalidException e) {
            e.printStackTrace();
        }
    }
}
