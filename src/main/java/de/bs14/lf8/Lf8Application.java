package de.bs14.lf8;

import de.bs14.lf8.Service.DatabaseInsertCheckerService;
import de.bs14.lf8.repository.CategoryRepository;
import de.bs14.lf8.repository.PlayerRepository;
import de.bs14.lf8.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.orm.jpa.vendor.Database;

@SpringBootApplication
@EnableConfigurationProperties
@RequiredArgsConstructor
public class Lf8Application implements CommandLineRunner {
	private final CategoryRepository categoryRepository;
	private final PlayerRepository playerRepository;
	private final QuestionRepository questionRepository;
	private final DatabaseInsertCheckerService databaseInsertCheckerService;

	public static void main(String[] args) {
		new SpringApplicationBuilder().sources(Lf8Application.class).run(args);
	}

	@Override
	public void run(String... args) {
			//long outputPlayer = playerRepository.count();
			//System.out.println(outputPlayer);
			databaseInsertCheckerService.preProcessDatabase();
			long output= categoryRepository.count();
			System.out.println(output);
			System.out.println(questionRepository.findAll());

		}
	}
