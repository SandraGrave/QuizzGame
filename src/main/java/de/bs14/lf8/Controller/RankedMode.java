package de.bs14.lf8.Controller;

import de.bs14.lf8.Service.CountdownThreadService;
import de.bs14.lf8.Service.InputReaderService;
import de.bs14.lf8.Service.PointSystemCalculatorService;
import de.bs14.lf8.Service.QuestionReaderService;
import de.bs14.lf8.Service.RankingService;
import de.bs14.lf8.model.Player;
import de.bs14.lf8.model.Question;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RankedMode implements GameMode { //gegen Zeit, Punkte sammeln möglich, keine Kategorie wählen

  private final QuestionReaderService questionReaderService;
  private final RankingService rankingService;
  private final PointSystemCalculatorService pointSystemCalculatorService;
  private final Map<Integer, Integer> roundPointsMap = new HashMap<>();

// Todo: Anzeigen, wie viele Punkte man mit der Runde erhalten hat

  @Override
  public void startGameModeRound(Player currentPlayer, InputReaderService inputReaderService, QuestionReaderService questionReaderService) {
    CountdownThreadService countdownThreadService = new CountdownThreadService();
    roundPointsMap.putIfAbsent(currentPlayer.getPlayerId(), 0);
    Question question = getQuestion();
    countdownThreadService.start();
    String playerAnswer = inputReaderService.readInputWithTimeLimit(countdownThreadService);
    int remainingTime = countdownThreadService.getRemainingTime();
    countdownThreadService.stopCountdown();
    if (questionReaderService.isPlayerAnswerRight(question, playerAnswer)) {
      pointSystemCalculatorService.setCalculatedPoints(currentPlayer);
      pointSystemCalculatorService.setCalculatedExtraPoints(currentPlayer, remainingTime);
      rankingService.setCalculatedRankingTitle(currentPlayer);
      addToRoundPointMap(currentPlayer);
    }
  }

  private void addToRoundPointMap(Player currentPlayer) {
    Integer currentCorrectAnswers = roundPointsMap.get(currentPlayer.getPlayerId());
    roundPointsMap.put(currentPlayer.getPlayerId(), currentCorrectAnswers + 1);
  }


  @Override
  public Question getQuestion() {
    return questionReaderService.printQuestionOfWholePool();

  }

  public void identifyWinner(Player multiplayerOne, Player multiplayerTwo) { //Todo: Wie berechne ich die Punkte, die erspielt wurden
    Integer roundPointsPlayerOne = roundPointsMap.get(multiplayerOne.getPlayerId());
    Integer roundPointsPlayerTwo = roundPointsMap.get(multiplayerTwo.getPlayerId());

    System.out.println(multiplayerOne.getPlayerName() + " hat " + roundPointsPlayerOne + " Punkte erspielt.");
    System.out.println(multiplayerTwo.getPlayerName() + " hat " + roundPointsPlayerTwo + " Punkte erspielt.");

    //TODO: IF oder Compare Sieger, Verlierer, Gleichstand
    //TODO: Map testen!
    //Todo: Somit hat SPIELERNAME gewonnen. Herzlichen Glückwunsch!

  }

}
