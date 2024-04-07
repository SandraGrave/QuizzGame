package de.bs14.lf8.Service;

import java.util.Timer;
import java.util.TimerTask;
import org.springframework.stereotype.Service;

@Service
public class CountdownThreadService extends Thread {

  private static final int timeLimitSeconds = 30;
  private int elapsedTime;
  private Timer timer;

  public CountdownThreadService() {
    this.elapsedTime = 0;
  }


  public void run() {
    timer = new Timer();
    timer.scheduleAtFixedRate(new TimerTask() {
      @Override
      public void run() {
        if (elapsedTime >= timeLimitSeconds) {
          timer.cancel();
        } else {
          if (timeLimitSeconds - elapsedTime <= 5)  // Weniger als oder gleich 5 Sekunden verbleiben, gib jede Sekunde aus
          {
            System.out.println("Verbleibende Zeit: " + (timeLimitSeconds - elapsedTime) + " Sekunden");

          } else { // Mehr als 5 Sekunden verbleiben, gib alle 5 Sekunden aus
            if (elapsedTime % 5 == 0) {
              System.out.println("Verbleibende Zeit: " + (timeLimitSeconds - elapsedTime) + " Sekunden");
            }
          }
          elapsedTime++;
        }
      }
    }, 0, 1000);

  }

  public boolean isTimeUp() {
    return elapsedTime >= timeLimitSeconds;
  }

  public void stopCountdown() {
    timer.cancel();
  }

  public int getRemainingTime() {
    return timeLimitSeconds - elapsedTime;
  }
}
