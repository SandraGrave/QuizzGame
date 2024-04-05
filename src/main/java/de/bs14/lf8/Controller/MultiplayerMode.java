package de.bs14.lf8.Controller;

import de.bs14.lf8.Service.CountdownThreadService;
import de.bs14.lf8.Service.InputReaderService;
import de.bs14.lf8.Service.QuestionReaderService;
import de.bs14.lf8.model.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MultiplayerMode implements GameMode { // TODo: 2 Spieler abwechselnd, mit Zeitlimit, mit Punkte sammeln

  QuestionReaderService questionReaderService;

  @Override
  public void startGameMode(CountdownThreadService countdownThreadService, InputReaderService inputReaderService,
      QuestionReaderService questionReaderService) {

  }

  @Override
  public void endGame() {

  }

  @Override
  public void getQuestion() {
    questionReaderService.printQuestionOfWholePool();
  }
}
