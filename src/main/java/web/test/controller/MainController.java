package web.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import web.test.model.Category;
import web.test.model.CategoryDTO;
import web.test.model.News;

import web.test.model.NewsDTO;
import web.test.service.CategoryService;
import web.test.service.NewsService;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Controller
public class MainController {
    @Autowired
    private NewsService newsService;
    @Autowired
    private CategoryService categoryService;


    @RequestMapping(value = "/news", method = RequestMethod.GET)
    public String getNews(Model model) {
        Category category = new Category();
        category.setName("IT");
        Long id = Long.valueOf(2);
        category.setId(id);
        Set<Category> categories = new HashSet<>();
        categories.add(category);
        List<NewsDTO> news = this.newsService.findNewsByCategory(category);

        model.addAttribute("news", news);

        return "news";
    }

    @RequestMapping(value = "/news", method = RequestMethod.POST)
    public String getNewsByCategory(Model model,@RequestParam(value = "name", required = false) Long id) {
        Category category = new Category();
        category.setId(id);
        Set<Category> categories = new HashSet<>();
        categories.add(category);
        List<NewsDTO> news = this.newsService.findNewsByCategory(category);

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
    public String add(@RequestParam(value = "name", required = false) String name,@RequestParam(value = "body", required = false) String body,@RequestParam(value = "option1", required = false) Integer id1,@RequestParam(value = "option2", required = false) Integer id2,@RequestParam(value = "option3", required = false) Integer id3,@RequestParam(value = "putdate", required = false) Date putdate,Model model) {
       Category curCategory = new Category();
        List<CategoryDTO> categoriesBD = categoryService.findCategories();
        if(id1!=null){
        curCategory.setName(categoriesBD.get(id1).getName());
        curCategory.setId(Long.valueOf(id1));}

        if(id2!=null){
            curCategory.setName(categoriesBD.get(id2).getName());
            curCategory.setId(Long.valueOf(id2));}

        if(id3!=null){
            curCategory.setName(categoriesBD.get(id3).getName());
            curCategory.setId(Long.valueOf(id3));}

        Set<Category> categories = new HashSet<>();
        categories.add(curCategory);
        this.newsService.save(name, body, categories, putdate);
        model.addAttribute("name", name);
       model.addAttribute("body", body);
        model.addAttribute("categories", categories);
       model.addAttribute("putdate", putdate);
        return "addednews";
    }
}
