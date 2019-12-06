package by.artezio.controller;

import by.artezio.application.ApplicationService;
import by.artezio.entity.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class TestAppController{
        private static Logger log = Logger.getLogger("ReactTestcintroller");

    @Autowired
    ApplicationService applicationService;

    @RequestMapping(value = "/newapp", method = RequestMethod.POST)
    public Application saveNewApp(@RequestBody Application application){
        log.info("applicationUrl: "+application.getAppUrl());
        applicationService.addApplication(application);
        return application;
    }

}
