package de.bs14.lf8;

import de.bs14.lf8.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@RequiredArgsConstructor
public class Lf8Application implements CommandLineRunner {

	private final CategoryRepository categoryRepository;
	public static void main(String[] args) {
		new SpringApplicationBuilder().sources(Lf8Application.class).run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		while(true){
			long output= categoryRepository.count();
			System.out.println(output);
		}
	}
}
