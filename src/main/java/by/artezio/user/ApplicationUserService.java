package by.artezio.user;

import by.artezio.entity.ApplicationRole;
import by.artezio.entity.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ApplicationUserService {

    @Autowired
    private ApplicationUserDAO dao;

    public List<ApplicationUser> findAll() {
        return dao.findAll();
    }

    public void deleteAll() {
        dao.deleteAll();
    }

    public void addUser(ApplicationUser user) {
        dao.save(user);
    }

    public ApplicationUser findUserById(Long id) {
        return dao.findOne(id);
    }

    public void deleteById(Long id) {
        dao.delete(id);
    }

    public Long getCountUsers() {
        return dao.count();
    }

    public ApplicationUser findByLogin(String login) {
        return dao.findByLogin(login);
    }

    public ApplicationUser findByEmail(String email) {
        return dao.findByEmail(email);
    }


    public List<ApplicationUser> findAllByApplicationId(Long id) {
        return dao.findApplicationUsersByApplicationId(id);
    }



}
