package by.artezio.testController;

import by.artezio.entity.ApplicationUser;
import by.artezio.entity.Session;
import by.artezio.service.SessionService;
import by.artezio.testRepo.AppUserRepository;
import by.artezio.testServise.AppUserServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    AppUserServise userServise;


    @Autowired
    SessionService sessionService;

    @GetMapping
    public void test(){
    userServise.save();


    }




}
