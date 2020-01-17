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

}
