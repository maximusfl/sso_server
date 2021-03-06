package by.artezio;

import by.artezio.entity.Application;
import by.artezio.entity.ApplicationRole;
import by.artezio.entity.ApplicationUser;
import by.artezio.entity.Session;
import org.apache.commons.lang3.RandomStringUtils;


import java.util.Collections;
import java.util.Date;


public interface TestSampleData {

    ApplicationUser testUser = new ApplicationUser(

            "testName",
            "testLogin",
            "testPassword",
            "test@email.ru",
            Collections.emptySet(),
            Collections.emptySet());


    ApplicationRole testRole = new ApplicationRole(
            new Application(),
            "testRoleName",
            "description for test",
            Collections.emptySet());

    Application testApplication = new Application("testapp.com",
            "tets",
            "testDesc",
            Collections.emptySet());


    Session testSession = new Session(
            RandomStringUtils.random(10, true, true),
            new Date(),
            testUser);

}


