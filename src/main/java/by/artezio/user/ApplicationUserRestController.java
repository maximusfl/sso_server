package by.artezio.user;

import by.artezio.entity.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class ApplicationUserRestController {
    private static Logger logger = Logger.getLogger("ApplicationUserRestController");
    @Autowired
    ApplicationUserService userService;

    @GetMapping(path = "/application/{id}/user")
    public List<ApplicationUser> getUsersByApplication(@PathVariable Long id){
        logger.info("called getUsersByApplication method" );
        for(ApplicationUser user : userService.findAllByApplicationId(id)){
            logger.info(" User: " + user);
        }
        return userService.findAllByApplicationId(id);

    }

}
