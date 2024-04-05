package de.bs14.lf8.Controller;

import de.bs14.lf8.Service.CountdownThreadService;
import de.bs14.lf8.Service.InputReaderService;
import de.bs14.lf8.Service.QuestionReaderService;
import de.bs14.lf8.Service.RankingService;
import de.bs14.lf8.model.Question;
import de.bs14.lf8.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SoloMode implements GameMode { //gegen Zeit, Punkte sammeln möglich, keine Kategorie wählen

  private final QuestionReaderService questionReaderService;
  private final QuestionRepository questionRepository;
  private final CountdownThreadService countdownThread;
  private final RankingService rankingService;

// ToDO: Punkte berechnen + speichern
// Todo: Anzeigen, wie viele Punkte man mit der Runde erhalten hat

  @Override
  public void startGameMode(CountdownThreadService countdownThreadService, InputReaderService inputReaderService,
      QuestionReaderService questionReaderService) {
    Question question = questionReaderService.getRandomQuestion(questionReaderService.getAllQuestions(questionRepository));
    questionReaderService.printQuestion(question);
    countdownThread.start();
    String playerAnswer = inputReaderService.readInputWithTimeLimit(countdownThread);
    countdownThread.stopCountdown();
    questionReaderService.isPlayerAnswerRight(question, playerAnswer);

  }

  @Override
  public void endGame() {
    String nextLine = System.lineSeparator();
    System.out.println(nextLine + "Hier siehst du die aktuelle Rangliste:");
    rankingService.showRankingList();

  }

  @Override
  public void getQuestion() {
    questionReaderService.printQuestionOfWholePool();
  }

}
