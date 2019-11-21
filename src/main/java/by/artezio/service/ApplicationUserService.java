package by.artezio.service;

import by.artezio.dao.ApplicationUserDAO;
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

}
