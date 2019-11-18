package by.artezio.repo;

import by.artezio.entity.AppUser;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class AppUserRepository {

    @PersistenceContext
    EntityManager entityManager;

    protected  EntityManager getEntityManager(){
        return this.entityManager;
    }


    public void saveUser(AppUser appUser) {
        entityManager.persist(appUser);
    }

    public void getUser(){
        System.out.println(entityManager.createQuery("from app_user", AppUser.class));
    }
}
