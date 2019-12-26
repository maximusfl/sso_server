package by.artezio.application;

import by.artezio.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ApplicationDAO extends JpaRepository<Application, Long> {
    @Query("from Application where applicationUrl = ?1")
    Application findByUrl(String url);
}
