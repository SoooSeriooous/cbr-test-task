package my.test.cbrtask.repositories;

import my.test.cbrtask.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
  Boolean existsAuthorsByBirthDateAndNameAndSurname(
      LocalDate birthDate, String name, String surname);
}
