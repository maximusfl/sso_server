package by.artezio.session;

import by.artezio.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionDAO extends JpaRepository<Session, String> {
}
