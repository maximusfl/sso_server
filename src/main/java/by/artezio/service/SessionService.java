package by.artezio.service;

import by.artezio.dao.impl.SessionDaoImpl;
import by.artezio.entity.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SessionService {

    @Autowired
    SessionDaoImpl sessionDao;

    public void save(Session session){
        sessionDao.save(session);
    }

}
