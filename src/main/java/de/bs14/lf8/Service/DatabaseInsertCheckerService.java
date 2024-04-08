package de.bs14.lf8.Service;


import de.bs14.lf8.repository.CategoryRepository;
import de.bs14.lf8.repository.QuestionRepository;
import org.hibernate.sql.Insert;
import org.springframework.stereotype.Service;

@Service
public class DatabaseInsertCheckerService {
  private final QuestionRepository questionRepository;
  private final CategoryRepository categoryRepository;
  private final InsertService insertService;


  public DatabaseInsertCheckerService(QuestionRepository questionRepository, CategoryRepository categoryRepository, InsertService insertService){
    this.questionRepository = questionRepository;
    this.categoryRepository = categoryRepository;
    this.insertService = insertService;

  }
  private boolean isDatabaseEmtpy() {
    if (questionRepository.count() == 0 || categoryRepository.count() == 0 ) {
      return true;
    } return false;

  }

  public void preProcessDatabase(){
    if (isDatabaseEmtpy()) {
    insertService.createInserts();
    }

  }
}
