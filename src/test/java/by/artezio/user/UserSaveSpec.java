package by.artezio.user;

import by.artezio.configuration.JpaConfiguration;
import by.artezio.entity.ApplicationUser;
import by.artezio.TestSampleData;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@Transactional
@WebAppConfiguration
@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class, classes = {JpaConfiguration.class})
public class UserSaveSpec implements TestSampleData {

    @Autowired
    private ApplicationUserService userService;

    @Before
    public void clean() {
        userService.deleteAll();
    }

    @Test
    public void isDataBaseEmpty() {
        assertTrue(userService.findAll().isEmpty());
    }

    @Test
    public void saveUserWithMock() {
        ApplicationUserDAO localMockRepository = Mockito.mock(ApplicationUserDAO.class);
        ApplicationUser testUser = TestSampleData.testUser;
        localMockRepository.save(testUser);
        Mockito.verify(localMockRepository).save(testUser);
    }

    @Test
    public void addTestUser() {
        userService.addUser(testUser);
        assertNotNull(userService.findAll());
    }

    @Test
    public void findByApp() {
        userService.findAllByApplicationId(1L);
    }

}
