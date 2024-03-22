package de.bs14.lf8.repository;

import de.bs14.lf8.model.Category;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository  extends CrudRepository<Category, Integer> {

}
