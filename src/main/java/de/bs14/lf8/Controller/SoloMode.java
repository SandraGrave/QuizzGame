package de.bs14.lf8.Controller;

import de.bs14.lf8.Service.CountdownThreadService;
import de.bs14.lf8.Service.InputReaderService;
import de.bs14.lf8.Service.PlayerReaderService;
import de.bs14.lf8.Service.PointSystemCalculatorService;
import de.bs14.lf8.Service.QuestionReaderService;
import de.bs14.lf8.Service.RankingService;
import de.bs14.lf8.model.Player;
import de.bs14.lf8.model.Question;
import de.bs14.lf8.repository.PlayerRepository;
import de.bs14.lf8.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SoloMode implements GameMode { //gegen Zeit, Punkte sammeln möglich, keine Kategorie wählen

  private final QuestionReaderService questionReaderService;
  private final QuestionRepository questionRepository;
  private final CountdownThreadService countdownThread;
  private final RankingService rankingService;
  private final PlayerReaderService playerReaderService;
  private final PlayerRepository playerRepository;
  private final PointSystemCalculatorService pointSystemCalculatorService;

// Todo: Anzeigen, wie viele Punkte man mit der Runde erhalten hat

  @Override
  public void startGameModeRound(Player currentPlayer, InputReaderService inputReaderService, QuestionReaderService questionReaderService) {
    CountdownThreadService countdownThreadService = new CountdownThreadService();
    Question question = getQuestion();
    countdownThreadService.start();
    String playerAnswer = inputReaderService.readInputWithTimeLimit(countdownThreadService);
    countdownThreadService.stopCountdown();
    pointSystemCalculatorService.setCalculatedPoints(currentPlayer, question, playerAnswer);
    rankingService.setCalculatedRankingTitle(currentPlayer);
  }

  @Override
  public void endGame() {
    String nextLine = System.lineSeparator();

    System.out.println(nextLine + "Hier siehst du die aktuelle Rangliste:");
    rankingService.showRankingList();

  }

  @Override
  public Question getQuestion() {
    return questionReaderService.printQuestionOfWholePool();

  }

}
