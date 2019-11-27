//package by.artezio.session;
//
//import by.artezio.TestSampleData;
//import by.artezio.configuration.JpaConfiguration;
//import by.artezio.entity.Session;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//
//import javax.persistence.EntityManager;
//import javax.transaction.Transactional;
//
//import static org.junit.Assert.*;
//import static org.junit.Assert.*;
//@RunWith(SpringRunner.class)
//@Transactional
//@WebAppConfiguration
//@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class,
//        classes = {JpaConfiguration.class})
//public class SessionServiceTest implements TestSampleData {
//
//    SessionService localService = Mockito.mock(SessionService.class);
//
//    @Test
//    public void addSession() {
//
//        localService.addSession(testSession);
//        Mockito.verify(localService).addSession(testSession);
//
//
//    }
//
//    @Test
//    public void getSessionById() {
//        Mockito.when(localService.getSessionById("zzz")).thenReturn(testSession);
//        Session session = localService.getSessionById("zzz");
//        Mockito.verify(localService).getSessionById("zzz");
//        assertEquals(testUser, session.getUser());
//    }
//
//
//}