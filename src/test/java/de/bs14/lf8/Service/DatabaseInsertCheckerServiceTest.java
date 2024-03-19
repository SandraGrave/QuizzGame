package de.bs14.lf8.Service;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import de.bs14.lf8.model.Question;
import de.bs14.lf8.repository.CategoryRepository;
import de.bs14.lf8.repository.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DatabaseInsertCheckerServiceTest {

  QuestionRepository questionRepositoryMock = Mockito.mock(QuestionRepository.class);
  CategoryRepository categoryRepositoryMock = Mockito.mock(CategoryRepository.class);
  InsertService insertServiceMock =  Mockito.mock(InsertService.class);
  DatabaseInsertCheckerService databaseInsertCheckerService = new DatabaseInsertCheckerService(questionRepositoryMock, categoryRepositoryMock, insertServiceMock);


  @Test
  void whenCheckDatabaseInsertsWithZeroInsertsThenFillDatabase() {
    //given
    when(questionRepositoryMock.count()).thenReturn(0L);
    when(categoryRepositoryMock.count()).thenReturn(0L);

    //when
    databaseInsertCheckerService.preProcessDatabase();

    //then
    verify(insertServiceMock, times(1)).createInserts();
  }

  @Test
  void whenCheckDatabaseInsertsWithFilledInsertsThenDontFillDatabase() {
    //given
    when(questionRepositoryMock.count()).thenReturn(1L);
    when(categoryRepositoryMock.count()).thenReturn(1L);

    //when
    databaseInsertCheckerService.preProcessDatabase();

    //then
    verify(insertServiceMock, times(0)).createInserts();
  }

}

