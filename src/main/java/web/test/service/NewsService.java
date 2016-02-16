
package web.test.service;

import org.springframework.data.jpa.repository.Query;

import web.test.model.Category;
import web.test.model.News;
import web.test.model.NewsDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public interface NewsService {
    List<NewsDTO> findNewsByCategory(Category categories);

    List<NewsDTO> findAll();

    NewsDTO getNews(Long id);

    void save(String name,String body,Set<Category> categories,Date putdate);

    void delete(String name);
}