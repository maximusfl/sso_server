package by.artezio.role;

import by.artezio.entity.Application;
import by.artezio.entity.ApplicationRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@RestController
@RequestMapping("/application/{id}/role")
//@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RoleRestController {
    private static Logger log = Logger.getLogger("ApplicationRoleController");
    @Autowired
    ApplicationRoleService roleService;

    @GetMapping
    public List<ApplicationRole> getAllApplicationsRoles(@PathVariable Long id) {
        log.info("called method getAllApplicationsRoles");
        log.info("Application id: " + id);
        log.info("roles: " + " " + roleService.getRolesByApplication(id));
        return roleService.getRolesByApplication(id);
    }

    @PostMapping
    public void saveNewRole(@PathVariable Long id, @RequestBody ApplicationRole requestRole) {
        log.info("trying to save new role for application id: " + id);
        ApplicationRole role = requestRole;
        log.info("roleName: " + role.getRoleName() + " roleDescription: " + role.getRoleDescription());
        Application application = new Application();
        application.setId(id);
        role.setApplication(application);
        roleService.addRole(role);
    }

    @DeleteMapping
    public void deleteRole(@RequestBody Long id, HttpServletRequest request) {
        log.info("role id from request: " + id);
//        Long roleId = Long.parseLong("|"+id+"|");
//        log.info("role id : "+roleId);
        try {
            roleService.deleteRoleById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
