package by.artezio.role;

import by.artezio.entity.Application;
import by.artezio.entity.ApplicationRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.logging.Logger;

@Controller
@RequestMapping("/addrole")
public class AddRoleController {
    private static Logger log = Logger.getLogger("AddRoleController");
    @Autowired
    ApplicationRoleService roleService;

    @GetMapping("/{appUrl}")
    public String showAddRolePage(@PathVariable String appUrl, Model model){
log.info("url: "+appUrl);

model.addAttribute(appUrl);
        return "addRolePage";
    }
}
