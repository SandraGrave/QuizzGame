package de.bs14.lf8.Service;

import java.io.IOException;
import java.util.Scanner;
import org.springframework.stereotype.Service;

@Service
public class InputReaderService {

  private long startTime;

  public String readInputWithTimeLimit(Long timeToWait) {
    Scanner scanner = new Scanner(System.in);
    startTime = System.currentTimeMillis();
    while (System.currentTimeMillis() - startTime < timeToWait) {
      try {
        if (System.in.available() > 0) {

          return scanner.nextLine();

        }
      } catch (IOException e) {
        throw new RuntimeException(e);
      }

    }

    scanner.close();
    return "";
  }

  public String readInput() {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      try {
        if (System.in.available() > 0) {
          System.out.println("test2");
          String output = scanner.nextLine();
          scanner.close();
          return output;

        }

      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
  }


  public void stopWaiting() {
    startTime = 0;
  }
}
