package de.bs14.lf8.Service;

import de.bs14.lf8.Controller.RankedMode;
import de.bs14.lf8.Controller.TrainingMode;
import de.bs14.lf8.model.Player;
import de.bs14.lf8.repository.PlayerRepository;
import java.util.Scanner;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GameModeMenu {

  private final InputReaderService inputReaderService;
  private final QuestionReaderService questionReaderService;
  private final PlayerReaderService playerReaderService;
  private final PlayerRepository playerRepository;
  private final RankedMode rankedMode;
  private final TrainingMode trainingMode;
  private final RankingService rankingService;


  public void chooseGameMode() {

    String nextLine = System.lineSeparator();

    Scanner in = new Scanner(System.in);
    Boolean x = true;
    while (x) {

      System.out.println("--------------------------");
      System.out.println("Wähle einen Spiel-Modus");
      System.out.println("1. Singleplayer - Spieler alleine gegen die Zeit und sammel Rangpunkte.");
      System.out.println("2. Training - Übe ohne Zeitlimit bestimmte Kategorien (Rangpunkte sammeln ist hier nicht möglich.");
      System.out.println("3. Multiplayer - Spiele gegen einen anderen Spieler und sammelt Rangpunkte.");
      System.out.println("4. Gehe zum Main-Menu");
      System.out.println("Gib deine Wahl ein: ");

      String s = in.nextLine();

      switch (s) {
        case "1":
          System.out.println("Willkommen zum Singleplayer-Mode" + nextLine + "Das Spiel startet!");
          Player currentPlayer = playerReaderService.findCurrentPlayer(playerRepository);
          for (int i = 0; i <= 2; i++) {
            rankedMode.startGameModeRound(currentPlayer, inputReaderService, questionReaderService);
          }
          rankedMode.endGame(rankingService);
          x = false;
          break;

        case "2":
          System.out.println("Willkommen zum Training-Mode" + nextLine + "Das Spiel startet!");
          Player currentTrainingPlayer = playerReaderService.findCurrentPlayer(playerRepository);
          for (int i = 0; i <= 2; i++) {
            trainingMode.startGameModeRound(currentTrainingPlayer, inputReaderService, questionReaderService);
          }
          trainingMode.endGame(rankingService);
          x = false;
          break;

        case "3":
          System.out.println("Willkommen zum Multiplayer-Mode" + nextLine + "Das Spiel startet!");
          Player multiplayerOne = playerReaderService.findCurrentPlayer(playerRepository);
          for (int i = 0; i <= 2; i++) {
            rankedMode.startGameModeRound(multiplayerOne, inputReaderService, questionReaderService);
          }
          System.out.println("Spielerwechsel steht an!");
          Player multiplayerTwo = playerReaderService.findCurrentPlayer(playerRepository);
          for (int i = 0; i <= 2; i++) {
            rankedMode.startGameModeRound(multiplayerTwo, inputReaderService, questionReaderService);
          }
          rankedMode.identifyWinner(multiplayerOne, multiplayerTwo); //Todo: Wer hat gewonnen?
          rankedMode.endGame(rankingService);
          x = false;
          break;

        case "4":
          System.out.println("Zurück zum Main-Menü");
          x = false;

        default:
          System.out.println("Ungültige Eingabe " + s);
          break;
      }


    }
  }
}
