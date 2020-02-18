package my.test.cbrtask.services;

import my.test.cbrtask.configs.BookMapper;
import my.test.cbrtask.dtos.BookDto;
import my.test.cbrtask.entities.Author;
import my.test.cbrtask.entities.Book;
import my.test.cbrtask.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

  private final BookRepository bookRepository;

  public BookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public List<BookDto> getItems() {
    List<Book> books = bookRepository.findAll();
    return books.stream().map(BookMapper.BOOK_MAPPER::fromBook).collect(Collectors.toList());
  }

  public BookDto getItemById(Long id) {
    Book book = bookRepository.findById(id).orElse(new Book());
    return BookMapper.BOOK_MAPPER.fromBook(book);
  }

  /**
   * Когда удаляю книгу - автор остаётся.
   *
   * @param id
   */
  public void deleteItem(Long id) {
    bookRepository.deleteById(id);
  }

  public void updateBook(BookDto editedBook) {
    Book book = BookMapper.BOOK_MAPPER.toBook(editedBook);
    bookRepository.save(book);
  }

  public void saveBook(BookDto newBook) {
    Book book = BookMapper.BOOK_MAPPER.toBook(newBook);
    if (!bookRepository.existsBooksByName(book.getName())) {
      bookRepository.save(book);
    }
  }
}
