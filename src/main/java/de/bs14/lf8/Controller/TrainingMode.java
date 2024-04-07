package de.bs14.lf8.Controller;

import de.bs14.lf8.Service.CountdownThreadService;
import de.bs14.lf8.Service.InputReaderService;
import de.bs14.lf8.Service.QuestionReaderService;
import de.bs14.lf8.Service.RankingService;
import de.bs14.lf8.model.Player;
import de.bs14.lf8.model.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TrainingMode implements GameMode { //ToDO: Kein Zeitlimit, Keine Punkte sammeln möglich, Nach Kategorien filtern möglich

  QuestionReaderService questionReaderService;
  RankingService rankingService;

  @Override
  public void startGameModeRound(Player currentPlayer, InputReaderService inputReaderService,
      QuestionReaderService questionReaderService) {

  }

  @Override
  public void endGame() {
    rankingService.showRankingList();
  }

  @Override
  public Question getQuestion() {
    questionReaderService.printQuestionOfCategoryPool();

    return null;
  }
}
