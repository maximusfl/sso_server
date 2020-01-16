package by.artezio.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/myRedirect")
public class Redirect {
    @GetMapping
    public ModelAndView test(){
        return new ModelAndView("testRedirect" );
    }
}
