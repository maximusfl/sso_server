package by.artezio.application;

import by.artezio.entity.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/application")
public class AddAppRestController {
    private static Logger log = Logger.getLogger("ApplicationController");

    @Autowired
    ApplicationService applicationService;

    @PostMapping
    public void saveNewApp(@RequestBody Application application) {

        log.info("applicationUrl: " + application.getAppUrl() +
                " appName: " + application.getAppName() +
                " description: " + application.getDescription());
        applicationService.addApplication(application);
    }

}
