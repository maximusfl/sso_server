package by.artezio.servise;

import by.artezio.entity.AppUser;
import by.artezio.repo.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AppUserServise {
    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public void saveNewUser(AppUser user){
        AppUser appUser = new AppUser();
        appUser.setEmail("m.kotau@mail.ru");
        appUser.setName("max");
        appUser.setPassword(passwordEncoder.encode("password"));
        appUser.setUserName("maximus");
        appUserRepository.saveUser(appUser);
    }

    public void getUser(){
        appUserRepository.getUser();
    }

}
