package by.artezio.application;

import by.artezio.entity.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/application")
public class ApplicationRestController {
    private static Logger log = Logger.getLogger("ApplicationController");

    @Autowired
    ApplicationService applicationService;

    @GetMapping
    public List<Application> getAllApplications(){
        return applicationService.getAllApplications();
    }

    @GetMapping("/{id}")
    public Application findApplicationById(@PathVariable Long id){
        return applicationService.findApplicationById(id);
    }

    @PostMapping
    public void saveNewApplication(@RequestBody Application application) {

        log.info("applicationUrl: " + application.getApplicationUrl() +
                " appName: " + application.getApplicationName() +
                " description: " + application.getDescription());
        applicationService.addApplication(application);
    }



}
