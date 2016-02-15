package web.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import web.test.dao.NewsRepository;
import web.test.model.Category;
import web.test.model.News;
import web.test.model.NewsDTO;

import javax.transaction.Transactional;
import java.util.ArrayList;
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
    public List<NewsDTO> findNews(String category) {
        Assert.notNull(category, "Criteria must not be null");
        List<News> news =this.newsRepository.findByCategory(category);
        List<NewsDTO> newsDTO = new ArrayList<>();
        for (News curNews:news){
            newsDTO.add(curNews.toDTO());
        }
     return newsDTO;
    }



    @Override
    public NewsDTO getNews(Long id) {
        Assert.notNull(id, "Criteria must not be null");
        News news = this.newsRepository.findOne(id);
        NewsDTO newsDTO =news.toDTO();
        return newsDTO ;
    }



    @Override
    public void save(String name, String body, Category category, Date putdate) {
        News news = new News();
        news.setName(name);
        news.setBody(body);
       // news.setCategory(category);
        news.setPutdate(putdate);
        this.newsRepository.save(news);
    }

    @Override
    public void delete(String name){

    }
}
