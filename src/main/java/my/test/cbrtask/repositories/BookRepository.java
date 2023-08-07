package my.test.cbrtask.repositories;

import my.test.cbrtask.entities.Author;
import my.test.cbrtask.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

  @Transactional
  void deleteBooksByAuthor(Author author);

  Boolean existsBooksByName(String name);
}
