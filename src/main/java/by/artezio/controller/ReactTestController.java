package by.artezio.controller;

import by.artezio.entity.ApplicationUser;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class ReactTestController {



    @RequestMapping(value = "/react", method = RequestMethod.POST)
    public ApplicationUser testReact(
            @RequestBody ApplicationUser user
    ) {
ApplicationUser applicationUser = user;

        return applicationUser;
    }
}
