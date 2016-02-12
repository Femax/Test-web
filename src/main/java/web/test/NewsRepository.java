package web.test;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by fedosovmax on 12.02.16.
 */
public interface NewsRepository extends CrudRepository<News,Long> {


        List<News> findByIdNews(int id_news);

        List<News> findAll();

}
