package by.artezio.role;

import by.artezio.entity.ApplicationRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.logging.Logger;

public interface ApplicationRoleDAO extends JpaRepository<ApplicationRole, Long> {

    @Query(value = "from ApplicationRole where application.id = ?1")
    List<ApplicationRole> getApplicationRolesByApplicationID(Long id);

    ApplicationRole findApplicationRoleByApplication_IdAndRoleName(Long id, String roleName);


    @Query(value = "select roles from ApplicationRole roles join roles.application app join roles.user us where app.id=?1 and us.id=?2")
    List<ApplicationRole> findApplicationRolesByApplicationAndUser(Long id, Long userId);


}
