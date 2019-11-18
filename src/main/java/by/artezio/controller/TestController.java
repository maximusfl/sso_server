package by.artezio.controller;

import by.artezio.entity.AppUser;
import by.artezio.servise.AppUserServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    AppUserServise userServise;

    @RequestMapping(method = RequestMethod.GET)
    public void showTestPage(){
        userServise.getUser();
    }

}
