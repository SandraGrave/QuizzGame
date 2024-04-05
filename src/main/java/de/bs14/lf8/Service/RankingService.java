/*package de.bs14.lf8.Service;

import de.bs14.lf8.model.Player;
import de.bs14.lf8.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RankingService {

  private final PlayerRepository playerRepository;

  public void showRankingList() {
    String nextLine = System.lineSeparator();
    String playerFormat = "%-11s | %-10s | %-4s";

    System.out.printf(playerFormat, "Spielername", "Rangpunkte", "Rangtitel" + nextLine);

    Sort sort = Sort.by("rankingPoints").descending();
    Iterable<Player> sortPlayerList = playerRepository.findAll(sort);

    for (Player player : sortPlayerList) {
      System.out.printf(playerFormat, player.getPlayerName(), player.getRankingPoints(), player.getRankingTitle() + nextLine);
    }

  }
}
*/
package de.bs14.lf8.Service;

import de.bs14.lf8.model.Player;
import de.bs14.lf8.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RankingService {

  private final PlayerRepository playerRepository;
  //private final Player player;

  public void showRankingList() {
    String nextLine = System.lineSeparator();
    String playerFormat = "%-11s | %-10s | %-4s";

    System.out.printf(playerFormat, "Spielername", "Rangpunkte", "Rangtitel" + nextLine);

    Sort sort = Sort.by("rankingPoints").descending();
    Iterable<Player> sortPlayerList = playerRepository.findAll(sort);

    for (Player player : sortPlayerList) {
      System.out.printf(playerFormat, player.getPlayerName(), player.getRankingPoints(), player.getRankingTitle() + nextLine);
    }

  }
  public void setRankingTitle(Player player){
    int rankingPoints = player.getRankingPoints();

    if (rankingPoints >= 120) {
      player.setRankingTitle("Gold");
      playerRepository.save(player);
    } else if (rankingPoints >= 90) {
      player.setRankingTitle("Silver");
      playerRepository.save(player);
    } else if (rankingPoints >= 50) {
      player.setRankingTitle("Bronze");
      playerRepository.save(player);
    } else if (rankingPoints >= 10) {
      player.setRankingTitle("Iron");
      playerRepository.save(player);
    } else {
      player.setRankingTitle("Noch keinen Titel");
      playerRepository.save(player);
    }

  }



}


