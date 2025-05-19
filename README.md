# LF8 - Quizz-Spiel

Dieses Projekt wurde für Lernfeld 8 der Berufsschule durchgeführt. Wir waren eine Gruppe von 4 Leuten. Hier war ich die einzige Person mit Programmier-Kenntnissen, somit habe ich das gesamte Programm gecodet und war die Hilfestellung für meine Gruppe und konnte ihnen teilweise etwas beibringen. (Die Pipeline habe ich jedoch nicht erstellt.)

Die Idee:
Ein Quizz-Spiel, wo man Punkte sammeln kann, gegeneinander spielen kann und ein Rankingsystem vorhanden ist. Wir wollten ein Programm, mit dem man theoretisch für bevorstehende Prüfungen lernen könnte.
Es gibt verschiedene Game-Modes (Single-Player ohne Punkte sammeln, Single-Player mit Punkte sammeln und Multiplayer).


Probleme und Lösungen, auf die wir gestoßen sind:

- Einrichten der Datenbank hat etwas gedauert.
  Wir hatten zwischenzeitig eine .sql-Datei., die die Datenbank erstellte. War nicht persistent

- Dann für Methode entschieden, eine inmemory-Datenbank mit Spring zu erstellen

- inserts wurden jedes mal versucht auszuführen. Kam zustande, weil die IDs doppelt vergeben wurden, Methode erstellt, die die inserts nur
  ausführt, wenn noch gar keine Inserts vorhanden sind
  Hier haben wir uns mit dem Test bzw. dem Mocken etwas schwer getan

- bei den GameModes gab es Anfangs einige Probleme mit Interface, aber wir wollten gern Interface benutzen. Gelernt, dass es default Methoden gibt!

- Relativ spät am Ende ist aufgefallen, dass unsere DB immer noch nicht persistent war. In der yml dann von create auf update geändert.

- Map genutzt, um beim MultiplayerMode Punkte zwischenzuspeichern bevor sie in die DB geladen werden, damit ein Gewinner von dieser Runde
  ermittelt werden kann. Am Ende der Runde wir die Map geleert

- System. in + System. out
  (Nicht darauf ausgelegt, dass Console beides gleichzeitig macht, kam zu Problemen, bzw. ist immer noch buggy: wenn VerbleibendeSekunden-Ausgabe
  genau zeitgleich mit Input vom Player passiert, wird die Eingabe gelöscht, Problem hätte man nicht, wenn man eine UI hätte)
  Vorübergehend so gelöst, dass alle 5 Sekunden nur eine neue Ausgabe mit verbleibender Zeit kommt, um die Wahrscheinlichkeit des Bug-Auslösens zu verringern. In Zukunft sollte eine UI gebaut werden.


  Alles in Allem funktioniert das Programm jedoch.
  
