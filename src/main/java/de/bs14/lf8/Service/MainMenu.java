package de.bs14.lf8.Service;

import java.util.Scanner;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MainMenu {

    private final GameModeMenu gameModeMenu;
    private final HelpService helpService;
    private final RankingService rankingService;
    private final InsertService insertService;
    public void showMainMenu() {


        Scanner in = new Scanner(System.in);
        boolean x = true;
        while(x) {
          System.out.println("--------------------------");
          System.out.println("Willkommen zum Quiz-Spiel");
          System.out.println("1. Wähle Spiel-Modus");
          System.out.println("2. Zeige Rangliste");
          System.out.println("3. Spiel beenden");
          System.out.println("4. Fragen hinzufügen");
          System.out.println("h. Zeige Hilfe-Menü");
          System.out.println("Gib deine Wahl ein und bestätige mit Enter: ");

          String s = in.nextLine();

          switch (s) {
            case "1":
              System.out.println("Wähle Spiel Modus");
              gameModeMenu.chooseGameMode();
              break;

            case "2":
              System.out.println("Ranking List");
              rankingService.showRankingList();
              break;

            case "3":
               System.out.println("Spiel wird beendet...");
               x = false;
               break;

            case "4":
                System.out.println("Neue Frage hinzufügen");
                System.out.println("-------------------------");
                insertService.newInsertQuestion();
                break;

            case "h":
                System.out.println("Willkommen ins Help Menu");
                System.out.println("----------------------------");
                helpService.showHelp();
                break;

            default:
                System.out.println("Ungültige Eingabe " + s);
                break;
            }



     }
  }

}
