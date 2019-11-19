package by.artezio.controller;

import by.artezio.entity.ApplicationRole;
import by.artezio.entity.ApplicationUser;
import by.artezio.servise.AppUserServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.management.relation.Role;
import java.util.HashSet;
import java.util.Set;


@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    AppUserServise userServise;

    @GetMapping
    public void test(){
    userServise.save();


    }



}
