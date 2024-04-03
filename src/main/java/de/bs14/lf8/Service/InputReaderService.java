package de.bs14.lf8.Service;

import java.io.IOException;
import java.util.Scanner;
import org.springframework.stereotype.Service;

@Service
public class InputReaderService {

  private long startTime;
  Scanner scanner = new Scanner(System.in);

  public String readInputWithTimeLimit(CountdownThreadService countdownThreadService) {
    startTime = System.currentTimeMillis();

    while (!countdownThreadService.isTimeUp()) {

      try {
        if (System.in.available() > 0) {

          return scanner.nextLine();

        }
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    System.out.println("Zeit abgelaufen!");
    return "";
  }


  public String readInput() {
    while (true) {
      if (scanner.hasNextLine()) {
        String output = scanner.nextLine();
        return output;

      }

    }
  }


  public void stopWaiting() {
    startTime = 0;
  }
}
