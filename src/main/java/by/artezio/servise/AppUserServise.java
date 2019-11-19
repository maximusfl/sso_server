package by.artezio.servise;

import by.artezio.repo.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AppUserServise {
    @Autowired
    private AppUserRepository appUserRepository;

    public void save() {
        appUserRepository.save();
    }


//    @Autowired
//    PasswordEncoder passwordEncoder;



}
