package by.artezio;
import org.junit.Assert;
import by.artezio.configuration.JpaConfiguration;
import by.artezio.dao.ApplicationUserDAO;
import by.artezio.entity.ApplicationUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import javax.transaction.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@WebAppConfiguration
@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class,
        classes = { JpaConfiguration.class})
public class InMemoryTest {

    @Resource
    private ApplicationUserDAO userDAO;

    @Test
    public void givenLoadedUser_whenRead_then_ok(){
        ApplicationUser user = new ApplicationUser();
        user.setEmail("test@test.ru");
        user.setName("name");
        user.setPassword("password");
        user.setUserName("userNmae");

        userDAO.save(user);

        ApplicationUser user2 = userDAO.findOne(1L);

        Assert.assertEquals("name",user2.getName() );

    }
}
