package web.test.dao;

import org.springframework.data.repository.CrudRepository;
import web.test.model.Category;

import java.util.List;

/**
 * Created by fedosovmax on 16.02.16.
 */
public interface CategoryRepository extends CrudRepository<Category,Long> {
    List<Category> findAll();
    Category getByName(String name);

}
