package de.bs14.lf8.Controller;

import de.bs14.lf8.Service.InputReaderService;
import de.bs14.lf8.Service.PlayerReaderService;
import de.bs14.lf8.Service.QuestionReaderService;
import de.bs14.lf8.model.Player;
import de.bs14.lf8.model.Question;
import de.bs14.lf8.repository.PlayerRepository;

public interface GameMode {

  void startGameModeRound(Player currentPlayer, InputReaderService inputReaderService, QuestionReaderService questionReaderService);

  void endGame();

  Question getQuestion();

}
