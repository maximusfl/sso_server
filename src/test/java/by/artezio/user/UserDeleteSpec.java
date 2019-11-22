package by.artezio.user;

import static org.junit.Assert.*;

import by.artezio.TestSampleData;
import by.artezio.configuration.JpaConfiguration;
import by.artezio.entity.ApplicationUser;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@RunWith(SpringRunner.class)
@Transactional
@WebAppConfiguration
@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class,
        classes = {JpaConfiguration.class})
public class UserDeleteSpec implements TestSampleData {
    @Autowired
    ApplicationUserService userService;

    @Before
    public void addUsers() {
        userService.addUser(user);
    }

//    @Test
//    public void checkSize() {
//        userService.deleteById(1L);
//        assertEquals(9L,(long) userService.getCountUsers());
//    }

    @Test
    public void testdeleteUsers() {
        System.out.println(userService.findAll().size());
//        userService.deleteAll();
//        assertTrue(userService.findAll().isEmpty());
    }


}
