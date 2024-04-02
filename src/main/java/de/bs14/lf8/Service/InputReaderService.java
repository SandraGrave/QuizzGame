package de.bs14.lf8.Service;

import java.io.IOException;
import java.util.Scanner;
import org.springframework.stereotype.Service;

@Service
public class InputReaderService {

  private long startTime;

  public String readInputWithTimeLimit(CountdownThreadService countdownThreadService) {

    startTime = System.currentTimeMillis();
    Scanner scanner = new Scanner(System.in);
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
    Scanner scanner = new Scanner(System.in);
    while (true) {
      if (scanner.hasNextLine()) {
        String output = scanner.nextLine();
        //scanner.close();
        return output;

      }

    }
  }


  public void stopWaiting() {
    startTime = 0;
  }
}
