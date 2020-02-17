package my.test.cbrtask.repositories;

import my.test.cbrtask.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {}
