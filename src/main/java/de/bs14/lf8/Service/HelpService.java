package de.bs14.lf8.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@RequiredArgsConstructor
@Service
public class HelpService {

    public void showHelp(){

        String nextLine = System.lineSeparator();
        System.out.println("Wie beantworte ich die Fragen?" + nextLine + "Um die Fragen zu beantworten, gib A, B, C oder D ein und bestätige mit der Enter-Taste." + nextLine);
        System.out.println("Wie funktioniert die Rang Liste?" + nextLine + "Punkteberechnung: Jeder Spieler sammelt Punkte durch das Beantworten von Fragen im Quiz. Die Rangliste findest du in Menu und nach jeder Runde wird die Rangliste angezeigt. "
                + nextLine + "Die Rangliste wird regelmäßig aktualisiert, um die neuesten Punktestände der Spieler wiederzuspiegeln. Neue Punkte werden hinzugefügt, wenn Spieler weitere Fragen im Quiz beantworten, und die Rangliste wird entsprechend neu sortiert." + nextLine);
        System.out.println("Wie sammele ich die Ranking Punkte?" + nextLine + "Um Ranking-Punkte zu sammeln, müssen Spieler die Fragen im Quiz richtig beantworten."
                + nextLine + "Pro richtige Frage gibt es einen Punkt. Um einen Bonus-Punkt zu bekommen, musst du die Frage unter 5 Sekunden antworten." + nextLine);


    }
}