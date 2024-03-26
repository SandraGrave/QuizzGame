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

