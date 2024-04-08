package de.bs14.lf8.Service;

import de.bs14.lf8.model.Question;
import de.bs14.lf8.repository.CategoryRepository;
import de.bs14.lf8.repository.PlayerRepository;
import de.bs14.lf8.repository.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class InsertServiceTest {
    InputReaderService inputReaderServiceMock = Mockito.mock(InputReaderService.class);
    QuestionReaderService questionReaderServiceMock = Mockito.mock(QuestionReaderService.class);
    QuestionRepository questionRepositoryMock = Mockito.mock(QuestionRepository.class);
    CategoryRepository categoryRepositoryMock = Mockito.mock(CategoryRepository.class);
    PlayerRepository playerRepositoryMock = Mockito.mock(PlayerRepository.class);
    InsertService insertService = new InsertService(questionRepositoryMock, categoryRepositoryMock, playerRepositoryMock, inputReaderServiceMock, questionReaderServiceMock);
    @Test
    void testNewInsertQuestionIsInDatabase() {
        //given
        String categoryId = "1";
        String diffculty = "2";
        String questionValue = "Wie geht es dir?";
        String answerOptionA = "A. Gut";
        String answerOptionB = "B. Geht";
        String answerOptionC = "C. Solala";
        String answerOptionD = "D. Sehr gut";
        String rightAnswer = "D";

        Mockito.when(inputReaderServiceMock.readInput()).thenReturn(categoryId);
        Mockito.when(inputReaderServiceMock.readInput()).thenReturn(diffculty);
        Mockito.when(inputReaderServiceMock.readInput()).thenReturn(questionValue);
        Mockito.when(inputReaderServiceMock.readInput()).thenReturn(answerOptionA);
        Mockito.when(inputReaderServiceMock.readInput()).thenReturn(answerOptionB);
        Mockito.when(inputReaderServiceMock.readInput()).thenReturn(answerOptionC);
        Mockito.when(inputReaderServiceMock.readInput()).thenReturn(answerOptionD);
        Mockito.when(inputReaderServiceMock.readInput()).thenReturn(rightAnswer);

        //when
        insertService.newInsertQuestion();

        //then
        assertNotNull(questionRepositoryMock);

    }
}