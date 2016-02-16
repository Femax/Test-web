package web.test.service;

import web.test.model.Category;
import web.test.model.CategoryDTO;
import web.test.model.NewsDTO;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by fedosovmax on 16.02.16.
 */
public interface CategoryService {

    void save(String name);

    void delete(String name);

    List<CategoryDTO> findCategories();
}
