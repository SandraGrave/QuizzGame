package de.bs14.lf8.Service;

import de.bs14.lf8.model.Player;
import de.bs14.lf8.model.Question;
import de.bs14.lf8.repository.PlayerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class PointSystemCalculatorService {
    private final QuestionReaderService questionReaderService;
    private final PlayerRepository playerRepository;

    @Transactional
    public void setCalculatedPoints(Player player, Question question, String playerAnswer) {
      int playerPoints = player.getRankingPoints();

      if (questionReaderService.isPlayerAnswerRight(question, playerAnswer)) {
        int newPlayerPoints = playerPoints + 1;
        player.setRankingPoints(newPlayerPoints);
        playerRepository.save(player);
        System.out.println("Du erhältst einen Punkt!");


      }

    }
}
