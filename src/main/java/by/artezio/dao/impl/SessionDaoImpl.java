package by.artezio.dao.impl;

import by.artezio.dao.SessionDAO;
import by.artezio.entity.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class SessionDaoImpl implements SessionDAO {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public void save(Session session) {
        entityManager.persist(session);
    }

}
