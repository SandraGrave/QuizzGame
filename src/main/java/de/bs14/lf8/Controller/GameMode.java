package de.bs14.lf8.Controller;

import de.bs14.lf8.Service.CountdownThreadService;
import de.bs14.lf8.Service.InputReaderService;
import de.bs14.lf8.Service.QuestionReaderService;

public interface GameMode {

  void startGameMode(CountdownThreadService countdownThreadService, InputReaderService inputReaderService,
      QuestionReaderService questionReaderService);


  void endGame();

  void getQuestion();

}
