package by.artezio.application;

import by.artezio.entity.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/apps")
public class ShowApplicationsController {

    @Autowired
    ApplicationService applicationService;

    @GetMapping
    public String showAllApplications(Model model){
        model.addAttribute("apps", applicationService.getAllApplications());
        return "allApplications";
    }

    @GetMapping("/{id}")
    public String showApp(@PathVariable Long id, Model model){
        Application application = applicationService.findApplicationById(id);
        model.addAttribute("app", application);
        return "singlApplicationPage";
    }


}
