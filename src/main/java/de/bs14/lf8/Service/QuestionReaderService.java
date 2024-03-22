package de.bs14.lf8.Service;

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

  //+ getQuestion() : Void
  //+ showQuestion() : String
  //+ getAnswerOptions() : Void
  //+ showAnswerOptions() : String

  public List<Question> getAllQuestions(QuestionRepository questionRepository) {
    List<Question> allQuestionList = (List<Question>) questionRepository.findAll();
    return allQuestionList;
  }


  public List<Question> getQuestionsByCategoryList() {
    long wantedCategoryAsLong = chooseCategoryOption();
    List<Question> questionsSpecificCategoryList = (List<Question>)  questionRepository.findQuestionsByCategory(wantedCategoryAsLong);
    return questionsSpecificCategoryList;
  }


  public Question getRandomQuestion(List<Question> questionList) {
    Random random = new Random();
    int randomIndex = random.nextInt(questionList.size());
    return questionList.get(randomIndex);
  }


  public void printQuestion(Question question) { //Soll sowohl für Random als auch Kategorie-bezogen funktionieren.

    //String rightAnswer = question.getRightAnswer();

    System.out.println("Frage: " + question.getQuestionStatement());
    System.out.println("Antwort " + question.getAnswerOptionA());
    System.out.println("Antwort " + question.getAnswerOptionB());
    System.out.println("Antwort " + question.getAnswerOptionC());
    System.out.println("Antwort " + question.getAnswerOptionD());
  }

  public Long chooseCategoryOption() {
    System.out.println("Wähle eine der folgenden Kategorien indem du die entsprechende Nummer eingibst und mit Enter bestätigst");
    System.out.println("1 - Projekt-Management");
    System.out.println("2 - Netzwerk");
    System.out.println("3 - Qualitäts-Management");
    System.out.println("4 - IT-Security");
    System.out.println("5 - IT-Systeme");
    System.out.println("6 - Wirtschaft / Business");
    System.out.println("7 - Software");
    String wantedCategory = inputReaderService.readInput();
    long wantedCategoryAsLong = Long.parseLong(wantedCategory);
    return wantedCategoryAsLong;
  }
}
