package de.bs14.lf8.Controller;

import de.bs14.lf8.Service.InputReaderService;
import de.bs14.lf8.Service.PlayerReaderService;
import de.bs14.lf8.Service.QuestionReaderService;
import de.bs14.lf8.Service.RankingService;
import de.bs14.lf8.model.Player;
import de.bs14.lf8.model.Question;
import de.bs14.lf8.repository.PlayerRepository;

public interface GameMode {

  void startGameModeRound(Player currentPlayer, InputReaderService inputReaderService, QuestionReaderService questionReaderService);

  default void endGame(RankingService rankingService) {
    String nextLine = System.lineSeparator();

    System.out.println(nextLine + "Hier siehst du die aktuelle Rangliste:");
    rankingService.showRankingList();

  }

  Question getQuestion();

}
