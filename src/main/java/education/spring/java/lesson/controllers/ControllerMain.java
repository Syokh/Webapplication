package education.spring.java.lesson.controllers;

import education.spring.java.lesson.model.Book;
import education.spring.java.lesson.services.ServiceBook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.List;

@Controller
@RequestMapping("/book")
public class ControllerMain {

    @Inject
    private ServiceBook serviceBook;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String helloword(ModelMap model){

        model.addAttribute("message", "Hello WORD!!!!!!!!");
        return "hello";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView allList(ModelMap model){
        ModelAndView modelAndView = new ModelAndView();

        List<Book> books = serviceBook.getAll();

        modelAndView.addObject("books", books);
        modelAndView.setViewName("book");

        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String add(@RequestBody Book book){
        serviceBook.save(book);
        return "OK";
    }

}
