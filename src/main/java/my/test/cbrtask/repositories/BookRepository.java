package my.test.cbrtask.repositories;

import my.test.cbrtask.entities.Author;
import my.test.cbrtask.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

  @Transactional
  void deleteBooksByAuthors(Author author);

  Boolean existsBooksByName(String name);
}
