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
    CountdownThreadService countdownThreadService = Mockito.mock(CountdownThreadService.class);


    Question question = new Question(2, 1, "Test Question", "answerOptionA", "answerOptionB", "answerOptionC", "answerOptionD", "A");
    Player player = new Player("TestPlayer2", "123");

    private final QuestionReaderService questionReaderService = new QuestionReaderService(questionRepositoryMock, inputReaderServiceMock,
        categoryRepository);
    private final PointSystemCalculatorService pointSystemCalculatorService = new PointSystemCalculatorService(playerRepositoryMock,
        countdownThreadService);

    @Test
    void testWhenCalculatePointsThenIncrementPoints() {
        //given
        String playerAnswer = "A";

        // when
        pointSystemCalculatorService.setCalculatedPoints(player);

        //then
        assertEquals(1, player.getRankingPoints());
    }

    //ToDO: Test, dass Punkt erhöht, wenn schon ein Puknt vorhanden ist (Sollte dan 2 Pkt sein)

}
