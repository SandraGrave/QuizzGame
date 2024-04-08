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
  private int wantedCategory = 0;

  @Override
  public void startGameModeRound(Player currentPlayer, InputReaderService inputReaderService, QuestionReaderService questionReaderService) {
    Question question = getQuestion();
    String playerAnswer = inputReaderService.readInput();
    questionReaderService.isPlayerAnswerRight(question, playerAnswer);
  }

  @Override
  public void endGame(RankingService rankingService) {
    GameMode.super.endGame(rankingService);
    wantedCategory = 0;
  }

  @Override
  public Question getQuestion() {
    if (wantedCategory == 0) {
      wantedCategory = questionReaderService.chooseCategoryOption();
    }
    return questionReaderService.printQuestionOfCategoryPool(wantedCategory);
  }
}
