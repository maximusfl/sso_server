package by.artezio.dao;


import by.artezio.entity.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationUserDAO extends JpaRepository<ApplicationUser, Long> {

}


