package web.test;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface NewsRepository extends CrudRepository<News, Long> {

    List<News> findByIdNews(int id_news);

    List<News> findAll();

}
