package de.bs14.lf8;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class Lf8Application implements CommandLineRunner {

	public static void main(String[] args) {
		new SpringApplicationBuilder().sources(Lf8Application.class).run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Test");
	}
}
