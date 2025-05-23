package de.bs14.lf8.Service;

import de.bs14.lf8.model.Player;
import de.bs14.lf8.repository.PlayerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class PointSystemCalculatorService {

  private final PlayerRepository playerRepository;

  public int calculatePoints(Player player){
    int playerPoints = player.getRankingPoints();
    return playerPoints + 1;
  }

  @Transactional
  public void setCalculatedPoints(Player player) {
    int newPlayerPoints = calculatePoints(player);
    player.setRankingPoints(newPlayerPoints);
    playerRepository.save(player);
    System.out.println("Du erhältst einen Punkt!");
  }

  @Transactional
  public boolean setCalculatedExtraPoints(Player player, int remainingTime) {
    if (remainingTime >= 15) {
      int newPlayerPoints = calculatePoints(player);
      player.setRankingPoints(newPlayerPoints);
      playerRepository.save(player);
      System.out.println("Du erhältst einen Zeit-Bonus-Punkt!");
      return true;
    }
    return false;
  }
}