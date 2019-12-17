package by.artezio.application;

import by.artezio.entity.Application;
import by.artezio.role.ApplicationRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Logger;

@Controller
@RequestMapping("/add")
public class AddApplicationController {
    private static Logger log = Logger.getLogger("AddAllpcationController");

    @Autowired
    ApplicationRoleService roleService;

    @Autowired
    ApplicationService applicationService;


    @GetMapping
    public String showAddAppPage(){

        return "addApplication";
    }

    @PostMapping("/app")
    public ModelAndView addNewApp(@RequestParam (value = "appurl") String appUrl,
                                  ModelMap model){

        if(applicationService.isApplicationUrlExist(appUrl)){
            log.info("appUrl: "+appUrl);
            model.addAttribute("appUrl", appUrl);
                return new ModelAndView("redirect:/error/{appUrl}", model);

        }

        Application application = new Application();
        application.setApplicationUrl(appUrl);
        applicationService.addApplication(application);
        log.info("appUrl: "+appUrl);
        model.addAttribute("appUrl",appUrl);
        return new ModelAndView("redirect:/addrole/{appUrl}", model);
    }

}
