package web.test.dao;

import org.springframework.data.repository.CrudRepository;
import web.test.model.News;
import java.util.List;

public interface NewsRepository extends CrudRepository<News, Long> {

    List<News> findByIdNews(int id_news);

    List<News> findByCategory(String category);

    List<News> findAll();

}
