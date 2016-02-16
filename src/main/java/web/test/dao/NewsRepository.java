package web.test.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import web.test.model.Category;
import web.test.model.News;
import java.util.List;
import java.util.Set;

public interface NewsRepository extends CrudRepository<News, Long> {
      List<News> findAll();

      //@Query(value = "select n from News n  join News_Category nc on n.id = nc.news_id where nc.category_id =?1")
      @Query(value = "SELECT * FROM news n JOIN news_category nc ON n.id=nc.news_id WHERE nc.category_id=?1", nativeQuery = true)
      List<News> getNewsByCategory(Long category_id);

}
