package web.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;


@Controller
public class MainController {
    @Autowired
    private NewsRepository newsRepository;

    @RequestMapping(path = "/index")
    @Transactional(readOnly = true)
    public String helloWorld(Model model) {

          List<News>news=this.newsRepository.findAll();

       model.addAttribute("news",news);
        return "index";
    }

}
