package de.bs14.lf8.Service;

import de.bs14.lf8.model.Category;
import de.bs14.lf8.model.Question;
import de.bs14.lf8.repository.CategoryRepository;
import de.bs14.lf8.repository.PlayerRepository;
import de.bs14.lf8.repository.QuestionRepository;
import java.util.Optional;
import org.hibernate.mapping.Any;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

        when(categoryRepositoryMock.findById(1)).thenReturn(Optional.of(new Category("testCategory")));

        Mockito.when(inputReaderServiceMock.readInput()).thenReturn(categoryId)
            .thenReturn(diffculty)
            .thenReturn(questionValue)
            .thenReturn(answerOptionA)
            .thenReturn(answerOptionB)
            .thenReturn(answerOptionC)
            .thenReturn(answerOptionD)
            .thenReturn(rightAnswer);

        //when
        insertService.newInsertQuestion();

        //then
        verify(questionRepositoryMock, times(1)).save(any());

    }

    @Test
    void testNewInsertQuestionWhenInvalidCategoryIdThenQuestionIsNotInDatabase() {
        //given
        String categoryId = "2";
        String diffculty = "2";
        String questionValue = "Wie geht es dir?";
        String answerOptionA = "A. Gut";
        String answerOptionB = "B. Geht";
        String answerOptionC = "C. Solala";
        String answerOptionD = "D. Sehr gut";
        String rightAnswer = "D";

        when(categoryRepositoryMock.findById(1)).thenReturn(Optional.of(new Category("testCategory")));

        Mockito.when(inputReaderServiceMock.readInput()).thenReturn(categoryId)
            .thenReturn(diffculty)
            .thenReturn(questionValue)
            .thenReturn(answerOptionA)
            .thenReturn(answerOptionB)
            .thenReturn(answerOptionC)
            .thenReturn(answerOptionD)
            .thenReturn(rightAnswer);

        //when
        insertService.newInsertQuestion();

        //then
        verify(questionRepositoryMock, times(0)).save(any());

    }
}