package by.artezio.application;

import by.artezio.entity.Application;
import by.artezio.entity.ApplicationRole;
import by.artezio.role.ApplicationRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/apps")
public class ShowApplicationsController {

    @Autowired
    ApplicationService applicationService;

    @Autowired
    ApplicationRoleService roleService;

    @GetMapping
    public String showAllApplications(Model model){
        model.addAttribute("apps", applicationService.getAllApplications());
        return "allApplications";
    }

    @GetMapping("/{id}")
    public String showApp(@PathVariable Long id, Model model){
        Application application = applicationService.findApplicationById(id);
        model.addAttribute("app", application);
        List<ApplicationRole> roles = roleService.getRolesByApplication(id);
        model.addAttribute("roles",roles);
        return "singlApplicationPage";
    }


}
