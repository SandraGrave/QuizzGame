package de.bs14.lf8.Controller;

import de.bs14.lf8.Service.InputReaderService;
import de.bs14.lf8.Service.PointSystemCalculatorService;
import de.bs14.lf8.Service.QuestionReaderService;
import de.bs14.lf8.Service.RankingService;
import de.bs14.lf8.model.Player;
import de.bs14.lf8.model.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TrainingMode implements GameMode {

  private final QuestionReaderService questionReaderService;
  private final RankingService rankingService;
  private final PointSystemCalculatorService pointSystemCalculatorService;

  @Override
  public void startGameModeRound(Player currentPlayer, InputReaderService inputReaderService, QuestionReaderService questionReaderService) {
    Question question = getQuestion();
    String playerAnswer = inputReaderService.readInput();
    questionReaderService.isPlayerAnswerRight(question, playerAnswer);
  }

  @Override
  public void endGame() {
    String nextLine = System.lineSeparator();

    System.out.println(nextLine + "Hier siehst du die aktuelle Rangliste:");
    rankingService.showRankingList();

  }

  @Override
  public Question getQuestion() {
    return questionReaderService.printQuestionOfCategoryPool();
  }
}
