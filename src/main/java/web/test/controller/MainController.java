package web.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import web.test.model.CategoryDTO;
import web.test.model.NewsDTO;
import web.test.service.CategoryService;
import web.test.service.NewsService;

import java.util.*;


@Controller
public class MainController {
    @Autowired
    private NewsService newsService;
    @Autowired
    private CategoryService categoryService;


    @RequestMapping(value = "/news", method = RequestMethod.GET)
    public String getNews(@RequestParam(value = "category", required = false) Long id, Model model) {
        List<NewsDTO> news;
        if (id!=null)
        news = this.newsService.findNewsByCategory(id);
        else
        news = this.newsService.findAll();

        model.addAttribute("news", news);

        return "news";
    }

    @RequestMapping(value = "/news/add", method = RequestMethod.GET)
    public String getAdd(Model model) {

        List<CategoryDTO> categories =categoryService.findCategories();
        model.addAttribute("categories",categories);
        return "addnews";
    }

    @RequestMapping(value = "/news/add", method = RequestMethod.POST)
    public String add(@RequestParam(value = "name", required = false) String name,@RequestParam(value = "body", required = false) String body,@RequestParam(value = "option1", required = false) Long id1,@RequestParam(value = "option2", required = false) Long id2,@RequestParam(value = "option3", required = false) Long id3,@RequestParam(value = "putdate", required = false) Date putdate,Model model) {
     List<Long> idsCategory = new ArrayList<>();
        if (id1!=null)
        idsCategory.add(id1);
        if (id2!=null)
        idsCategory.add(id2);
        if (id3!=null)
        idsCategory.add(id3);
        NewsDTO newsDTO = new NewsDTO();
        newsDTO.setName(name);
        newsDTO.setBody(body);
        newsDTO.setCategoriesId(idsCategory);
        newsDTO.setPutdate(putdate);
        this.newsService.save(newsDTO);
        model.addAttribute("name", name);
        model.addAttribute("body", body);
        model.addAttribute("putdate", putdate);
        return "addednews";
    }


    @RequestMapping(value = "/news/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value="id", required=true) Long id,
                         Model model) {



        // Call PersonService to do the actual deleting
        newsService.delete(id);

        // Add id reference to Model
        model.addAttribute("id", id);

        // This will resolve to /WEB-INF/jsp/deletedpage.jsp
        return "deletedpage";
    }


    @RequestMapping(value = "/news/update", method = RequestMethod.GET)
    public String updatepage(@RequestParam(value="id", required=true) Long id,
                         Model model) {


       NewsDTO newsDTO=newsService.getNews(id);

        List<CategoryDTO> categories = categoryService.findCategories();


        model.addAttribute("idNews", id);
        model.addAttribute("news",newsDTO);
        model.addAttribute("categories",categories);
        return "updatepage";
    }

    @RequestMapping(value = "/news/update", method = RequestMethod.POST)
    public String update(@RequestParam(value = "name", required = false) String name,@RequestParam(value = "body", required = false) String body,@RequestParam(value = "option1", required = false) Long id1,@RequestParam(value = "option2", required = false) Long id2,@RequestParam(value = "option3", required = false) Long id3,@RequestParam(value = "putdate", required = false) Date putdate,@RequestParam(value = "idNews", required = false) Long idNews,Model model) {
        List<Long> idsCategory = new ArrayList<>();
        if (id1!=null)
            idsCategory.add(id1);
        if (id2!=null)
            idsCategory.add(id2);
        if (id3!=null)
            idsCategory.add(id3);
        NewsDTO newsDTO = new NewsDTO();
        newsDTO.setIdNews(idNews);
        newsDTO.setName(name);
        newsDTO.setBody(body);
        newsDTO.setCategoriesId(idsCategory);
        newsDTO.setPutdate(putdate);
        this.newsService.update(newsDTO);
        model.addAttribute("name", name);
        model.addAttribute("body", body);
        model.addAttribute("date", putdate.getDate());
        model.addAttribute("month", putdate.getMonth());
        model.addAttribute("year", putdate.getYear());

        return "updatednews";
    }

}
