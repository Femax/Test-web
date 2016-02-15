package web.test.service;

import web.test.model.Category;
import web.test.model.News;
import web.test.model.NewsDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface NewsService {
    List<NewsDTO> findNews(String category);

    NewsDTO getNews(Long id);

    void save(String name,String body,Category category,Date putdate);

    void delete(String name);
}
