package web.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.test.model.News;

import web.test.service.NewsService;

import java.util.List;


@Controller
public class MainController {
    @Autowired
    private NewsService newsService;

    @RequestMapping(path = "/index")
    public String index(Model model) {

        List<News> news = this.newsService.findNews("IT");

        model.addAttribute("news", news);
        return "index";
    }

    @RequestMapping(value = "/news", method = RequestMethod.GET)
    public String getPersons(Model model) {

        List<News> news = this.newsService.findNews("IT");

        model.addAttribute("news", news);

        return "news";
    }

    @RequestMapping(value = "/news/add", method = RequestMethod.GET)
    public String getAdd(Model model) {

        model.addAttribute("personAttribute", new News());

        return "addnews";
    }

    @RequestMapping(value = "/persons/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("newsAttribute") News news) {

        this.newsService.save(news.getIdNews(), news.getName(), news.getBody(), news.getCategory(), news.getPutdate());

        return "addednews";
    }
}
