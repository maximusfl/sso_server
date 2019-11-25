package by.artezio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/adduser")
public class AddUserController {

    @GetMapping
    public String showAddUserPage(){
        return "adduser";
    }
}
