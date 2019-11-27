package by.artezio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorController {

    @GetMapping("/{appUrl}")
    public String showUrlExistsError(@PathVariable String appUrl, Model model){
        model.addAttribute("message" ,appUrl+" has registred already");
        return "error";

    }

}
