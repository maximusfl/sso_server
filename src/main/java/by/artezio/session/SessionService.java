package by.artezio.session;

import by.artezio.entity.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SessionService {
    @Autowired
    SessionDAO sessionDAO;

    public void addSession(Session session){
        sessionDAO.save(session);
    }

    public Session getSessionById(String id){
        return sessionDAO.findOne(id);
    }

    public void deleteSessionById (String id){
        sessionDAO.delete(id);
    }

    public List<Session> getAllSessions(){
        return sessionDAO.findAll();
    }

}
