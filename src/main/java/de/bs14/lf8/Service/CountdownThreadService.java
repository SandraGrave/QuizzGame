package de.bs14.lf8.Service;

import java.util.Timer;
import java.util.TimerTask;
import org.springframework.stereotype.Service;

@Service
public class CountdownThreadService extends Thread {

  private static final int TIME_LIMIT_SECONDS = 30;
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
        if (elapsedTime >= TIME_LIMIT_SECONDS) {
          timer.cancel();
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
