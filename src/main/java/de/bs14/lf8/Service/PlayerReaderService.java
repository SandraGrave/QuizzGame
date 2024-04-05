package de.bs14.lf8.Service;

import de.bs14.lf8.model.Player;
import de.bs14.lf8.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PlayerReaderService {
private final PlayerRepository playerRepository;
private final InputReaderService inputReaderService;


    public Player findCurrentPlayer(PlayerRepository playerRepository){
        System.out.println("Wie ist dein Spielername?");
        String playerName = inputReaderService.readInput();
        List<Player> currentPlayerList = playerRepository.findByPlayerName(playerName);
        //int currentPlayerId = currentPlayer.getPlayerId();
        //playerRepository.findById(currentPlayerId);
        return currentPlayerList.get(0);
    }



}
