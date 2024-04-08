package de.bs14.lf8.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import de.bs14.lf8.repository.PlayerRepository;
import de.bs14.lf8.model.Player;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;


class RankingServiceTest {

    PlayerRepository playerRepositoryMock = Mockito.mock(PlayerRepository.class);
    Player playerMock = Mockito.spy(Player.class);
    private final RankingService rankingService = new RankingService(playerRepositoryMock);


    @Test
    void testSetRankingTitleSilver() {
        // given
        int rankingPoints = 90;
        when(playerMock.getRankingPoints()).thenReturn(rankingPoints);

        // when
        rankingService.setCalculatedRankingTitle(playerMock);

        // then
        assertEquals("Silver", playerMock.getRankingTitle());




    }


    @Test
    void testSetRankingTitleGold() {
        // given
        int rankingPoints = 200;
        when(playerMock.getRankingPoints()).thenReturn(rankingPoints);

        // when
        rankingService.setCalculatedRankingTitle(playerMock);

        // then
        assertEquals("Gold", playerMock.getRankingTitle());




    }


    @Test
    void testSetRankingTitleNKT() {
        // given
        int rankingPoints = 0;
        when(playerMock.getRankingPoints()).thenReturn(rankingPoints);

        // when
        rankingService.setCalculatedRankingTitle(playerMock);

        // then
        assertEquals("Noch keinen Titel", playerMock.getRankingTitle());

    }

    @Test
    void testSetRankingTitlIrone() {
        // given
        int rankingPoints = 11;
        when(playerMock.getRankingPoints()).thenReturn(rankingPoints);

        // when
        rankingService.setCalculatedRankingTitle(playerMock);

        // then
        assertEquals("Iron", playerMock.getRankingTitle());

    }


    @Test
    void testSetRankingTitleBronze() {
        // given
        int rankingPoints = 55;
        when(playerMock.getRankingPoints()).thenReturn(rankingPoints);

        // when
        rankingService.setCalculatedRankingTitle(playerMock);

        // then
        assertEquals("Bronze", playerMock.getRankingTitle());

    }

}



