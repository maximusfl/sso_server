package by.artezio.role;

import by.artezio.entity.ApplicationRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/application/{id}/role")
public class RoleRestController {

    private static Logger log = Logger.getLogger("ApplicationRoleController");

    @Autowired
    ApplicationRoleService roleService;

    @GetMapping
    public List<ApplicationRole> getAllApplicationsRoles(@PathVariable Long id) {
        log.info("called method getAllApplicationsRoles");
        log.info("Application id: "+id);
        log.info("roles: "+" "+roleService.getRolesByApplication(id));
        return roleService.getRolesByApplication(id);

    }

}
