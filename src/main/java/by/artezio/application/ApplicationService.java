package by.artezio.application;

import by.artezio.entity.Application;
import by.artezio.entity.ApplicationRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ApplicationService {
    @Autowired
    ApplicationDAO applicationDAO;



    public void addApplication(Application application){
        applicationDAO.save(application);
    }

    public Application findApplicationById(Long id){
        return applicationDAO.findOne(id);
    }

    public void deleteAllApplications(){
        applicationDAO.deleteAll();
    }

    public void deleteApplicationById(Long id){
        applicationDAO.delete(id);
    }
    public List<Application> getAllApplications(){
        return applicationDAO.findAll();
    }

    public Application findApplicationByUrl(String url){
        return applicationDAO.findByUrl(url);
    }

    public Boolean isApplicationUrlExist(String url){
        if(applicationDAO.findByUrl(url) == null){
            return false;
        }
        else return true;
    }



}
