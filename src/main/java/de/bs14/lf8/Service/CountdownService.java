package de.bs14.lf8.Service;

import java.util.Timer;
import java.util.TimerTask;
import org.springframework.stereotype.Service;

@Service
public class CountdownService {

  private static final int TIME_LIMIT_SECONDS = 10;
  private int elapsedTime;
  private Timer timer;

  public CountdownService() {
    this.elapsedTime = 0;
  }


  public void startCountdown() {
    timer = new Timer();
    timer.scheduleAtFixedRate(new TimerTask() {
      public void run() {
        if (elapsedTime >= TIME_LIMIT_SECONDS) {
          timer.cancel();
          System.out.println("Zeit abgelaufen!");
        } else {
          System.out.println("Verbleibende Zeit: " + (TIME_LIMIT_SECONDS - elapsedTime) + " Sekunden");
          elapsedTime++;
        }
      }
    }, 0, 1000);

  }

  public boolean isTimeUp() {
    return elapsedTime >= TIME_LIMIT_SECONDS;
  }

  public void stopCountdown() {
    timer.cancel();
  }

  public int getRemainingTime() {
    return TIME_LIMIT_SECONDS - elapsedTime;
  }
}
