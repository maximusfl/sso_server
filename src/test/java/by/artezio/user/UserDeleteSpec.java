//package by.artezio.user;
//
//import static org.junit.Assert.*;
//
//import by.artezio.TestSampleData;
//import by.artezio.configuration.JpaConfiguration;
//import by.artezio.entity.ApplicationUser;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import javax.transaction.Transactional;
//
//@RunWith(SpringRunner.class)
//@Transactional
//@WebAppConfiguration
//@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class,
//        classes = {JpaConfiguration.class})
//public class UserDeleteSpec implements TestSampleData {
//    @Autowired
//    ApplicationUserService userService;
//
//    @Before
//    public void addUsers() {
//        userService.addUser(testUser);
//    }
//
//
//
//    @Test
//    public void testDeleteUsers() {
//        userService.deleteAll();
//        assertEquals(0,(long) userService.getCountUsers());
//
//    }
//
//    @Test
//    public void checkUserName(){
//        System.out.println(userService.getCountUsers());
//        ApplicationUser applicationUser = userService.findUserById(1L);
//        assertEquals("testName", applicationUser.getName());
//    }
//
//
//}
