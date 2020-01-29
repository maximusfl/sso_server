package by.artezio.role;

import by.artezio.TestSampleData;
import by.artezio.configuration.JpaConfiguration;
import by.artezio.entity.ApplicationRole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@Transactional
@WebAppConfiguration
@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class,
        classes = {JpaConfiguration.class})
public class RoleServiceSpec implements TestSampleData {
    @Autowired
    ApplicationRoleDAO roleDAO;

    @Autowired
    ApplicationRoleService roleService;

    ApplicationRoleService localService = Mockito.mock(ApplicationRoleService.class);


    @Test
    public void addRole() {
        localService.addRole(testRole);
        Mockito.verify(localService).addRole(testRole);
    }

    @Test
    public void findRoleById() {
        Mockito.when(localService.findRoleById(1L)).thenReturn(testRole);
        ApplicationRole role = localService.findRoleById(1L);

        Mockito.verify(localService).findRoleById(1L);

        assertEquals("testRoleName", role.getRoleName());
    }

    @Test
    public void getAllRoles() {
        localService.addRole(testRole);
        Mockito.verify(localService).addRole(testRole);

    }

    @Test
    public void getApplicationByRole() {
        testApplication.setRoles(new HashSet<ApplicationRole>(Set.of(testRole)));
        System.out.println(testApplication);
    }
    @Test
    public void testFindRolesByApplicationAndUser(){
        System.out.println(roleService.findUserRolesByUserIdAndApplicationId(1l,1l));

    }

    @Test
    public void getPid() throws IOException {
        Process process = Runtime.getRuntime().exec("java -version");
        ProcessHandle.Info info = process.info();
        System.out.println("PID = " + process.pid());
        System.out.println("User = " + info.user());
        System.out.println("Command = " + info.command());
        System.out.println("Args = " + info.arguments().map(Arrays::toString));
        System.out.println("Command Line = " + info.commandLine());
        System.out.println("Start Time = " + info.startInstant());
        System.out.println("Total Time = " + info.totalCpuDuration());
    }
}