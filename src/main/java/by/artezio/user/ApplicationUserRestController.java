package by.artezio.user;

import by.artezio.entity.ApplicationRole;
import by.artezio.entity.ApplicationUser;
import by.artezio.role.ApplicationRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/application/{id}/user")
public class ApplicationUserRestController {
    private static Logger logger = Logger.getLogger("ApplicationUserRestController");
    @Autowired
    ApplicationUserService userService;

    @Autowired
    ApplicationRoleService roleService;

    @GetMapping
    public List<ApplicationUser> getUsersByApplication(@PathVariable Long id) {
        logger.info("called getUsersByApplication method");
        for (ApplicationUser user : userService.findAllByApplicationId(id)) {
            logger.info(" User: " + user);
        }
        return userService.findAllByApplicationId(id);
    }

    @GetMapping(value = "/{id}")
    public ApplicationUser getUserById(@PathVariable Long id) {
        logger.info("called getUserByApplicationId ");
        ApplicationUser user = userService.findUserById(id);
        logger.info("user: " + user);
        return user;
    }

    @GetMapping(value = "/{userId}/role")
    public List<ApplicationRole> getRolesByAppIdAndUserId(@PathVariable Long id, @PathVariable Long userId) {
        logger.info("called getRolesByAppIdAndUserId");
        return roleService.findUserRolesByUserIdAndApplicationId(id, userId);
    }

    @Transactional
    @DeleteMapping(value = "/{userId}/role/{roleId}")
    public void deleteRoleFromUserByApplicationAndRoleId(@PathVariable Long userId, @PathVariable Long roleId) {
        ApplicationUser loadedUser = userService.findUserById(userId);
        Set<ApplicationRole> roles = loadedUser.getRole();
        roles.removeIf(applicationRole -> applicationRole.getId().equals(roleId));
        loadedUser.setRole(roles);
        userService.update(loadedUser);
    }

    @PutMapping(value = "/{userId}/role")
    @Transactional
    public void updateRole(@PathVariable Long userId, @RequestBody Long roleId) {
        logger.info("called updateRole");
        ApplicationUser loadedUser = userService.findUserById(userId);
        ApplicationRole newRole = roleService.findRoleById(roleId);
        loadedUser.getRole().add(newRole);
        logger.info("roles count: " + loadedUser.getRole().size());
        userService.update(loadedUser);
        logger.info("success");
    }

}
