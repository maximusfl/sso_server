package by.artezio.role;

import by.artezio.entity.ApplicationRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Logger;

@Controller
@RequestMapping("/roles")
public class EditRolecontroller {
    private static Logger log = Logger.getLogger("EditRoleController");
    @Autowired
    ApplicationRoleService roleService;

    @GetMapping("/{id}")
    public String showRolePage(Model model,
                               @PathVariable Long id) {
        ApplicationRole role = roleService.findRoleById(id);
        model.addAttribute("role", role);
        log.info("role: " + role);

        return "singleRolePage";
    }

    @PostMapping("update/{id}")
    public ModelAndView showEditedPage(
            ModelMap model,
            @PathVariable Long id,
            @RequestParam(value = "rolename") String rolename,
            @RequestParam(value = "roledescription") String roleDescription) {

        ApplicationRole loadedRole = roleService.findRoleById(id);
        log.info("loadedRole_id: "+ id);
        loadedRole.setRoleNmae(rolename);
        loadedRole.setRoleDescription(roleDescription);
        loadedRole.setId(id);
        roleService.update(loadedRole,id);
        Long application_id = loadedRole.getApplication().getId();
        model.addAttribute("id",application_id);
        return new ModelAndView( "redirect:/apps/{id}");
    }

    @PostMapping("delete/{id}")
    public ModelAndView removeRole(
            ModelMap model,
            @PathVariable Long id
    ){
        Long appIdForRedirect = roleService.findRoleById(id).getApplication().getId();
        roleService.deleteRoleById(id);
        model.addAttribute("id",appIdForRedirect);
        return new ModelAndView( "redirect:/apps/{id}");
    }
}
