package web.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import web.test.dao.NewsRepository;
import web.test.model.News;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * Created by fedosovmax on 14.02.16.
 */
@Component("NewsService")
@Transactional
public class NewsServiceImpl implements NewsService {



    private final   NewsRepository newsRepository;


    @Autowired
    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }



    @Override
    public List<News> findNews(String category) {
        Assert.notNull(category, "Criteria must not be null");
     return this.newsRepository.findByCategory(category);
    }



    @Override
    public News getNews(Long id) {
        Assert.notNull(id, "Criteria must not be null");

        return this.newsRepository.findOne(id);
    }



    @Override
    public void save(Long id_news, String name, String body, String category, Date putdate) {
        News news = new News();
        news.setId(id_news);
        news.setName(name);
        news.setBody(body);
        news.setCategory(category);
        news.setPutdate(putdate);

    }
}
