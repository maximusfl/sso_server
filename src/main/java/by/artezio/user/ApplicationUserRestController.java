package by.artezio.user;

import by.artezio.entity.ApplicationRole;
import by.artezio.entity.ApplicationUser;
import by.artezio.role.ApplicationRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
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
    public List<ApplicationRole> getRolesByAppIdAndUserId( @PathVariable Long id, @PathVariable Long userId){
        logger.info("called getRolesByAppIdAndUserId");
        return roleService.findUserRolesByUserIdAndApplicationId(id,userId);
    }

}
