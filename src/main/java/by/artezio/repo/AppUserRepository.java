package by.artezio.repo;

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




}
