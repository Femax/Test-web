package web.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import web.test.model.Category;
import web.test.model.News;

import web.test.model.NewsDTO;
import web.test.service.NewsService;

import java.util.Date;
import java.util.List;


@Controller
public class MainController {
    @Autowired
    private NewsService newsService;

    @RequestMapping(path = "/index")
    public String index(Model model) {

        List<NewsDTO> news = this.newsService.findNews("IT");

        model.addAttribute("news", news);
        return "index";
    }

    @RequestMapping(value = "/news", method = RequestMethod.GET)
    public String getPersons(Model model) {

        List<NewsDTO> news = this.newsService.findNews("IT");

        model.addAttribute("news", news);

        return "news";
    }

    @RequestMapping(value = "/news/add", method = RequestMethod.GET)
    public String getAdd(Model model) {

        model.addAttribute("personAttribute", new News());

        return "addnews";
    }

    @RequestMapping(value = "/news/add", method = RequestMethod.POST)
    public String add(@RequestParam(value = "name", required = false) String name,@RequestParam(value = "body", required = false) String body,@RequestParam(value = "category", required = false) String category,@RequestParam(value = "putdate", required = false) Date putdate,Model model) {
//        Category category1 = new Category();
//        .category1.setCategory(category);
//        this.newsService.save(name, body, category1, putdate);
//        model.addAttribute("name", name);
//        model.addAttribute("body",body);
//        model.addAttribute("category",category);
//        model.addAttribute("putdate",putdate);
        return "addednews";
    }
}
