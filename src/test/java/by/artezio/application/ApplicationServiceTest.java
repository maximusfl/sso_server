//package by.artezio.application;
//
//import by.artezio.TestSampleData;
//import by.artezio.configuration.JpaConfiguration;
//import by.artezio.entity.Application;
//import by.artezio.entity.ApplicationRole;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import javax.persistence.EntityManager;
//import javax.transaction.Transactional;
//
//import java.util.Set;
//
//import static org.junit.Assert.*;
//@RunWith(SpringRunner.class)
//@Transactional
//@WebAppConfiguration
//@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class,
//        classes = {JpaConfiguration.class})
//public class ApplicationServiceTest implements TestSampleData {
//    @Autowired
//    ApplicationDAO applicationDAO;
//
//    ApplicationService localApplicationService = Mockito.mock(ApplicationService.class);
//
//    @Before
//    public void setCondition() {
//        applicationDAO.save(testApplication);
//    }
//
//
//    @Test
//    public void addApplication() {
//
//        localApplicationService.addApplication(testApplication);
//        Mockito.verify(localApplicationService).addApplication(testApplication);
//
//    }
//
//    @Test
//    public void findApplicationById() {
//        Mockito.when(localApplicationService.findApplicationById(1L)).thenReturn(testApplication);
//        Application application = localApplicationService.findApplicationById(1L);
//        assertEquals("testapp.com", application.getApplicationUrl());
//    }
//
//    @Test
//    public void deleteAllApplications() {
//        localApplicationService.deleteAllApplications();
//        assertEquals(0, localApplicationService.getAllApplications().size());
//    }
//
//
//}