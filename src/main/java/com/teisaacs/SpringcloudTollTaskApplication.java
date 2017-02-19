package com.teisaacs;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class SpringcloudTollTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudTollTaskApplication.class, args);
	}
	
	@Bean
	public TollProcessingTask tollProcessingTask() {
		return new TollProcessingTask();
	}
	
	public class TollProcessingTask implements CommandLineRunner {

		@Override
		public void run(String... strings) throws Exception {
			//parameters stationid, licenseplate, timestamp
			
			if (null != strings) {
				//first param is the output type
				String stationId = strings[1];
				String licensePlate = strings[2];
				String timestamp = strings[3];
				
				System.out.println("parameter length is " + strings.length);
				System.out.println("Station ID: " + stationId + " plate: " + licensePlate + " time: " +timestamp);
			}
		}
		
	}
}
