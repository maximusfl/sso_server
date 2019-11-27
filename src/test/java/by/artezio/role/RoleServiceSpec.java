//package by.artezio.role;
//
//import by.artezio.TestSampleData;
//import by.artezio.configuration.JpaConfiguration;
//import by.artezio.entity.ApplicationRole;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
//import org.springframework.test.context.web.WebAppConfiguration;
//import javax.transaction.Transactional;
//import static org.junit.Assert.*;
//@RunWith(SpringRunner.class)
//@Transactional
//@WebAppConfiguration
//@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class,
//        classes = {JpaConfiguration.class})
//public class RoleServiceSpec implements TestSampleData {
//    @Autowired
//    ApplicationRoleDAO roleDAO;
//
//    @Autowired
//    ApplicationRoleService roleService;
//
//    ApplicationRoleService localService = Mockito.mock(ApplicationRoleService.class);
//
//
//
//    @Test
//    public void addRole() {
//        localService.addRole(testRole);
//        Mockito.verify(localService).addRole(testRole);
//    }
//
//    @Test
//    public void findRoleById() {
//        Mockito.when(localService.findRoleById(1L)).thenReturn(testRole);
//        ApplicationRole role = localService.findRoleById(1L);
//        Mockito.verify(localService).findRoleById(1L);
//        assertEquals("testRoleName",role.getRoleNmae());
//    }
//
//    @Test
//    public void getAllRoles() {
//        localService.addRole(testRole);
//        Mockito.verify(localService).addRole(testRole);
//
//    }
//}