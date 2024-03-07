package com.sample.amqp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class ReqreplyamqpApplication {

	/**
	 * Steps to run this app
	 *
	 * To run receiver
	 * java -jar target/tut1-0.0.1-SNAPSHOT.jar --spring.profiles.active=tut1,receiver
	 * OR java -jar target/tut1-0.0.1-SNAPSHOT.jar --spring.profiles.active=hello_world,receiver
	 *
	 * To run sender
	 * java -jar target/tut1-0.0.1-SNAPSHOT.jar --spring.profiles.active=tut1,sender --server.port=8091
	 * OR java -jar target/tut1-0.0.1-SNAPSHOT.jar --spring.profiles.active=hello_world,sender --server.port=8091
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ReqreplyamqpApplication.class, args);
	}

    @Profile("usage_message")
    @Bean
    CommandLineRunner usage(){
		return args -> {
			System.out.println("This app uses Spring profiles to control its behavior.\n");
			System.out.println("Sample usage: java -jar target/reqreplyamqp-0.0.1-SNAPSHOT.jar " +
					"--spring.profiles.active=rpc,server");
		};
	}

    @Profile("!usage_message")
    @Bean
    CommandLineRunner runner() {    	
		return new RabbitAmqpTutorialsRunner();
	}
	
}
