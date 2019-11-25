package by.artezio.role;

import by.artezio.entity.ApplicationRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ApplicationRoleDAO extends JpaRepository <ApplicationRole, Long> {

    @Query("from ApplicationRole where roleNmae=default")
    public List<ApplicationRole> getDefaultRoles();

}
