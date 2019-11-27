package by.artezio.role;

import by.artezio.entity.ApplicationRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.NamedQuery;
import java.util.List;
import java.util.Set;

public interface ApplicationRoleDAO extends JpaRepository <ApplicationRole, Long> {

    @Query( value = "from ApplicationRole where application.id = ?1")
     Set<ApplicationRole> getApplicationRolesByApplicationID(Long id);


}
