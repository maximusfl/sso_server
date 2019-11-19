package by.artezio.repo;

import by.artezio.entity.ApplicationRole;
import by.artezio.entity.ApplicationUser;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.Set;

@Repository
public class AppUserRepository {

    @PersistenceContext
    EntityManager entityManager;

    protected  EntityManager getEntityManager(){
        return this.entityManager;
    }


    public void save() {
        ApplicationRole role = new ApplicationRole();
        role.setRoleNmae("admin");
        Set<ApplicationRole> roles = new HashSet<>();

        ApplicationUser applicationUser = new ApplicationUser();
        applicationUser.setEmail("aaa");
        applicationUser.setUserName("sss");
        applicationUser.setPassword("tgfft");
        applicationUser.setRole(roles);

        entityManager.persist(applicationUser);


    }
}
