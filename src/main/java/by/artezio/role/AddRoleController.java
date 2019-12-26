package by.artezio.role;

import by.artezio.application.ApplicationService;
import by.artezio.entity.Application;
import by.artezio.entity.ApplicationRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Logger;

@Controller
@RequestMapping("/addrole")
public class AddRoleController {
    private static Logger log = Logger.getLogger("AddRoleController");
    @Autowired
    ApplicationRoleService roleService;
    @Autowired
    ApplicationService applicationService;

    @GetMapping("/{appUrl}")
    public String showAddRolePage(@PathVariable String appUrl, Model model) {
        log.info("url: " + appUrl);
        model.addAttribute(appUrl);
        return "addRolePage";
    }

    @PostMapping("/{appUrl}")
    public ModelAndView saveNewRole(
            ModelMap model,
            @PathVariable String appUrl,
            @RequestParam(value = "roleName") String roleName,
            @RequestParam(value = "roleDescription") String roleDescription){
        Application application = applicationService.findApplicationByUrl(appUrl);
        log.info("url: " + appUrl);
        ApplicationRole newRole = new ApplicationRole();
        newRole.setApplication(application);
        newRole.setRoleName(roleName);
        newRole.setRoleDescription(roleDescription);
        roleService.addRole(newRole);

        Long id = application.getId();
        model.addAttribute("id",id);
        return new ModelAndView("redirect:/apps/{id}");
    }

}
