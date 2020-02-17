package my.test.cbrtask.repositories;

import my.test.cbrtask.entities.Author;
import my.test.cbrtask.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    void deleteAllByAuthors(@Param("authors")List<Author> authors);
}
