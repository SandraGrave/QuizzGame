package de.bs14.lf8.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import de.bs14.lf8.model.Player;
import de.bs14.lf8.model.Question;
import de.bs14.lf8.repository.CategoryRepository;
import de.bs14.lf8.repository.PlayerRepository;
import de.bs14.lf8.repository.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PointSystemCalculatorServiceTest {

    QuestionRepository questionRepositoryMock = Mockito.mock(QuestionRepository.class);
    PlayerRepository playerRepositoryMock = Mockito.mock(PlayerRepository.class);
    InputReaderService inputReaderServiceMock = Mockito.mock(InputReaderService.class);
    CategoryRepository categoryRepository = Mockito.mock(CategoryRepository.class);


    Question question = new Question(2, 1, "Test Question", "answerOptionA", "answerOptionB", "answerOptionC", "answerOptionD", "A");
    Player player = new Player("TestPlayer2", "123");

    private final QuestionReaderService questionReaderService = new QuestionReaderService(questionRepositoryMock, inputReaderServiceMock,
        categoryRepository);
    private final PointSystemCalculatorService pointSystemCalculatorService = new PointSystemCalculatorService(questionReaderService,
        playerRepositoryMock);

    @Test
    void testWhenCalculatePointsAnswerIsRightThenCalculateNewPointsAndSaveInDatabase() {
        //given
        String playerAnswer = "A";

        // when
        pointSystemCalculatorService.calculatePoints(player, question, playerAnswer);

        //then
        assertEquals(1, player.getRankingPoints());
    }

    @Test
    void testWhenCalculatePointsAnswerIsWrongThenNoChange() {
        //given
        String playerAnswer = "B";

        // when
        pointSystemCalculatorService.calculatePoints(player, question, playerAnswer);

        //then
        assertEquals(0, player.getRankingPoints());
    }
}
