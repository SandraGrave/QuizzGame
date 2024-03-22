package de.bs14.lf8;

import de.bs14.lf8.Service.DatabaseInsertCheckerService;
import de.bs14.lf8.Service.InputReaderService;
import de.bs14.lf8.Service.QuestionReaderService;
import de.bs14.lf8.model.Question;
import de.bs14.lf8.repository.CategoryRepository;
import de.bs14.lf8.repository.PlayerRepository;
import de.bs14.lf8.repository.QuestionRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@RequiredArgsConstructor
public class Lf8Application implements CommandLineRunner {
	private final DatabaseInsertCheckerService databaseInsertCheckerService;
	private final QuestionReaderService questionReaderService;


	public static void main(String[] args) {
		new SpringApplicationBuilder().sources(Lf8Application.class).run(args);
	}

	@Override
	public void run(String... args) {
		databaseInsertCheckerService.preProcessDatabase();

		// Gib Random Frage aus kompletter Liste - funktioniert, bitte nicht löschen, brauchen wir für GameMode
		//List<Question> questionList = questionReaderService.getAllQuestions(questionRepository);
		//Question randomQuestion = questionReaderService.getRandomQuestion(questionList);
		//questionReaderService.printQuestion(randomQuestion);

		// Gib Random Frage aus Kategorienliste - funktioniert, bitte nicht löschen, brauchen wir für GameMode
		List<Question> questionsSpecificCategoryList = questionReaderService.getQuestionsByCategoryList();
		Question randomQuestion = questionReaderService.getRandomQuestion(questionsSpecificCategoryList);
		questionReaderService.printQuestion(randomQuestion);

		}
	}
