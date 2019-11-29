package by.artezio.role;

import by.artezio.entity.ApplicationRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
                               @PathVariable Long id){
        ApplicationRole role = roleService.findRoleById(id);
        model.addAttribute("role", role);
        log.info("role: "+role);

        return "singleRolePage";
    }

}
