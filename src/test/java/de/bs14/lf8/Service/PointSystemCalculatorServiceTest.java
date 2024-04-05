package de.bs14.lf8.Service;

import de.bs14.lf8.model.Player;
import de.bs14.lf8.model.Question;
import de.bs14.lf8.repository.PlayerRepository;
import de.bs14.lf8.repository.QuestionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PointSystemCalculatorServiceTest {
    PointSystemCalculatorService pointSystemCalculatorService = pointSystemCalculatorService = Mockito.mock(PointSystemCalculatorService.class);
    QuestionRepository questionRepositoryMock = questionRepositoryMock = Mockito.mock(QuestionRepository.class);
    PlayerRepository playerRepositoryMock = playerRepositoryMock = Mockito.mock(PlayerRepository.class);
    InputReaderService inputReaderServiceMock = inputReaderServiceMock = Mockito.mock(InputReaderService.class);


    Question question = new Question(2, 1, "Test Question", "answerOptionA", "answerOptionB", "answerOptionC", "answerOptionD", "A");
    Player player = new Player("TestPlayer2", "123");
    String playerAnswer = "A";
    @Test
    void testWhenCalculatePointsAnswerIsRightThenCalculateNewPointsAndSaveInDatabase() {


        //given
        Mockito.when(playerRepositoryMock.findAll()).thenReturn(List.of(player));
        Mockito.when(questionRepositoryMock.findAll()).thenReturn(List.of(question));
        Mockito.when(inputReaderServiceMock.readInput()).thenReturn(playerAnswer);

        // when

        output = pointSystemCalculatorService.calculatePoints(player, question, playerAnswer);


        //then
        assertEquals(player.getRankingPoints(), output);
    }
}
