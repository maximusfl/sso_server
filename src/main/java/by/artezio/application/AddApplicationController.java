package by.artezio.application;

import by.artezio.role.ApplicationRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/addapp")
public class AddApplicationController {

    @Autowired
    ApplicationRoleService roleService;


    @GetMapping
    public String showAddAppPage(){

        return "addapp";
    }

}
