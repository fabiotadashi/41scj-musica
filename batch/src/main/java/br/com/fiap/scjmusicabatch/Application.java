package br.com.fiap.scjmusicabatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.nio.file.Paths;

@SpringBootApplication
@EnableBatchProcessing
public class Application {

	private Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public Tasklet deletarArquivo(@Value("${arquivo.path}") String path){
		return (contribution, chunkContext) -> {
			File file = Paths.get(path).toFile();

			if(file.delete()){
				logger.info("Arquivo deletado com sucesso");
			} else {
				logger.warn("Não foi possível deletar o arquivo");
			}

			return RepeatStatus.FINISHED;
		};
	}

	@Bean
	public Step deleteStep(
			StepBuilderFactory stepBuilderFactory,
			Tasklet tasklet
	){
		return stepBuilderFactory.get("delete step")
				.tasklet(tasklet)
				.allowStartIfComplete(true)
				.build();
	}

	@Bean
	public Job job(
			JobBuilderFactory jobBuilderFactory,
			Step step
	){
		return jobBuilderFactory.get("Job delete file")
				.start(step)
				.build();
	}

}
