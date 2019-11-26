package by.artezio.application;

import by.artezio.entity.Application;
import by.artezio.role.ApplicationRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/add")
public class AddApplicationController {

    @Autowired
    ApplicationRoleService roleService;

    @Autowired
    ApplicationService applicationService;


    @GetMapping
    public String showAddAppPage(){

        return "addApplication";
    }

    @PostMapping("/app")
    public String addNewApp(@RequestParam (value = "appurl") String appUrl){

        Application application = new Application();
        application.setAppUrl(appUrl);
        applicationService.addApplication(application);
        return "addRolePage";
    }

}
