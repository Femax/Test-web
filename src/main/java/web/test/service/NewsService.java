package web.test.service;

import web.test.model.News;
import java.util.Date;
import java.util.List;

public interface NewsService {
    List<News> findNews(String category);

    News getNews(Long id);

    void save(Long id_news,String name,String body,String category,Date putdate);
}
