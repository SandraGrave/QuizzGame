package de.bs14.lf8.Service;

import de.bs14.lf8.model.Category;
import de.bs14.lf8.model.Question;
import de.bs14.lf8.repository.CategoryRepository;
import de.bs14.lf8.repository.QuestionRepository;
import java.util.List;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class QuestionReaderService {

  private final QuestionRepository questionRepository;
  private final InputReaderService inputReaderService;
  private final CategoryRepository categoryRepository;

  //+ getQuestion() : Void
  //+ showQuestion() : String
  //+ getAnswerOptions() : Void
  //+ showAnswerOptions() : String

  public List<Question> getAllQuestions(QuestionRepository questionRepository) {
    return (List<Question>) questionRepository.findAll();
  }


  public List<Question> getQuestionsByCategoryList() {
    long wantedCategoryAsLong = chooseCategoryOption();
    return questionRepository.findQuestionsByCategory(wantedCategoryAsLong);
  }


  public Question getRandomQuestion(List<Question> questionList) {
    Random random = new Random();
    int randomIndex = random.nextInt(questionList.size());
    return questionList.get(randomIndex);
  }


  public void printQuestion(Question question) {
    //String rightAnswer = question.getRightAnswer();

    System.out.println("Frage: " + question.getQuestionStatement());
    System.out.println("Antwort " + question.getAnswerOptionA());
    System.out.println("Antwort " + question.getAnswerOptionB());
    System.out.println("Antwort " + question.getAnswerOptionC());
    System.out.println("Antwort " + question.getAnswerOptionD());
  }

  private Long chooseCategoryOption() {
    String nextLine = System.lineSeparator();
    System.out.println("Wähle eine der folgenden Kategorien indem du die entsprechende Nummer eingibst und mit Enter bestätigst");
    List<Category> allCategories = (List<Category>) categoryRepository.findAll();
    String categoryFormat = " %-9s | %-4s ";
    System.out.printf(categoryFormat, "CategoryId", "CategoryName" + nextLine);

    for (Category category : allCategories) {
      System.out.printf(categoryFormat, category.getCategoryId(), category.getCategoryName() + nextLine);
    }

    String wantedCategory = inputReaderService.readInput();
    return Long.parseLong(wantedCategory);
  }
}
