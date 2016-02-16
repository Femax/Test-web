package web.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import web.test.dao.CategoryRepository;
import web.test.dao.NewsRepository;
import web.test.model.Category;
import web.test.model.News;
import web.test.model.NewsDTO;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Component("NewsService")
@Transactional
public class NewsServiceImpl implements NewsService {



    private final   NewsRepository newsRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public NewsServiceImpl(NewsRepository newsRepository,CategoryRepository categoryRepository) {
        this.newsRepository = newsRepository;
        this.categoryRepository = categoryRepository;
    }



    @Override
    public List<NewsDTO> findNewsByCategory(Category category) {
        Assert.notNull(category, "Criteria must not be null");
        List<News> news =this.newsRepository.getNewsByCategory(category.getId());
        List<NewsDTO> newsDTO = new ArrayList<>();
        for (News curNews:news){
            newsDTO.add(curNews.toDTO());
        }
     return newsDTO;
    }

    @Override
    public List<NewsDTO> findAll() {
        List<News> news =this.newsRepository.findAll();
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
    public void save(String name, String body, Set<Category> categories, Date putdate) {
        News news = new News();
        news.setName(name);
        news.setBody(body);
        news.setCategories(categories);
        news.setPutdate(putdate);
        this.newsRepository.save(news);
    }

    @Override
    public void delete(String name){

    }
}
