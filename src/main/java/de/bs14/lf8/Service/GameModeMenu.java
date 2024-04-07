package de.bs14.lf8.Service;

import de.bs14.lf8.Controller.SoloMode;
import de.bs14.lf8.model.Player;
import de.bs14.lf8.repository.PlayerRepository;
import java.util.Scanner;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GameModeMenu {

  private final SoloMode soloMode;
  private final InputReaderService inputReaderService;
  private final QuestionReaderService questionReaderService;
  private final PlayerReaderService playerReaderService;
  private final PlayerRepository playerRepository;

  public int chooseGameMode() {

    String nextLine = System.lineSeparator();
    int wantedGameMode = 0;

    Scanner in = new Scanner(System.in);
    Boolean x = true;
    while (x) {

      System.out.println("--------------------------");
      System.out.println("Wähle einen Spiel-Modus");
      System.out.println("1. Singleplayer - Spieler alleine gegen die Zeit");
      System.out.println("2. Training - Übe ohne Zeitlimit bestimmte Kategorien");
      System.out.println("3. Multiplayer - Spiele gegen einen anderen Spieler");
      System.out.println("4. Gehe zum Main-Menu");
      System.out.println("Gib deine Wahl ein: ");

      String s = in.nextLine();

      switch (s) {
        case "1":
          System.out.println("Willkommen zum Singleplayer Mode" + nextLine + "Das Spiel startet!");
          Player currentPlayer = playerReaderService.findCurrentPlayer(playerRepository);
          for (int i = 0; i <= 2; i++) {
            soloMode.startGameModeRound(currentPlayer, inputReaderService, questionReaderService);
          }
          soloMode.endGame();
          x = false;
          break;
        case "2":
          System.out.println("Willkommen zum Training Mode" + nextLine + "Das Spiel startet bald");
          x = false;
          wantedGameMode = 2;
          break;
        case "3":
          System.out.println("Willkommen zum Multiplayer Mode" + nextLine + "Das Spiel startet bald.");
          wantedGameMode = 3;
          break;
        case "4":
          System.out.println("Züruck zum Main-Menü");
          x = false;
        default:
          System.out.println("Ungültige Eingabe " + s);
          break;
      }


    }
    return wantedGameMode;
  }
}
