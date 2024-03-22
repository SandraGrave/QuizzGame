package de.bs14.lf8.repository;

import de.bs14.lf8.model.Question;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Integer> {
  List<Question> findQuestionsByCategory(long categoryId);

}
