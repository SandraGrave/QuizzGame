package de.bs14.lf8.Service;

import java.io.IOException;

public class InputReaderThreadService extends Thread {

  private final InputReaderService inputReaderService;
  private String playerAnswer;

  public InputReaderThreadService(InputReaderService inputReaderService) {
    this.inputReaderService = inputReaderService;
  }

  public void run() {
    playerAnswer = inputReaderService.readInputWithTimeLimit(10000L);

  }

  public void interrupt() { //wenn Zeit abgelaufen ist, soll nicht weiter auf Input vom Spieler gewartet werden, thread runterfahren
    inputReaderService.stopWaiting();
  }

  public boolean isAnswerGiven() {
    return playerAnswer != null;
  }

  public String getPlayerAnswer() {
    return playerAnswer;
  }
}
