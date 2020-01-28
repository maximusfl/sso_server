package by.artezio.user;


import by.artezio.entity.ApplicationRole;
import by.artezio.entity.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ApplicationUserDAO extends JpaRepository<ApplicationUser, Long> {

    @Query(value = "from ApplicationUser where login = ?1")
    ApplicationUser findByLogin(String login);

    @Query(value = "from ApplicationUser  where email =?1")
    ApplicationUser findByEmail(String email);

    @Query(value = "select user from   ApplicationUser user  join user.role role  where role.application.id =?1")
    List<ApplicationUser> findApplicationUsersByApplicationId(Long id);


}


