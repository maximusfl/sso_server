package by.artezio.role;

import by.artezio.entity.ApplicationRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRoleDAO extends JpaRepository <ApplicationRole, Long> {
}
