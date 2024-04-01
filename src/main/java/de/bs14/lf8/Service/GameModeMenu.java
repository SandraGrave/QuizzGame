package de.bs14.lf8.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@RequiredArgsConstructor
@Service
public class GameModeMenu {

    private final InputReaderService inputReaderService;

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
                    System.out.println("Willkommen zum Singleplayer Mode" + nextLine + "Der Spiel startet bald.");
                    x = false;
                    wantedGameMode = 1;
                    break;
                case "2":
                    System.out.println("Willkommen zum Training Mode" + nextLine + "Der Spiel startet bald");
                    x = false;
                    wantedGameMode = 2;
                    break;
                case "3":
                    System.out.println("Willkommen zum Multiplayer Mode" + nextLine + "Der Spiel startet bald.");
                    wantedGameMode = 3;
                    break;
                case "4":
                    System.out.println("Züruck zum Main-Menu");
                    x = false;
                default:
                    System.out.println("Ungültige Eingabe " + s);
                    break;
            }


        }
        return wantedGameMode;
    }
}
