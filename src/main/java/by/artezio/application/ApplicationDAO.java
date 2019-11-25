package by.artezio.application;

import by.artezio.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationDAO extends JpaRepository<Application, Long> {
}
