package by.artezio.application;

import by.artezio.entity.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class ShowApplicationsRestController {
    @Autowired
    ApplicationService applicationService;

    @GetMapping("/showapp")
    public List<Application> getAllApplications(){
        return applicationService.getAllApplications();
    }

}
