package my.test.cbrtask.services;

import my.test.cbrtask.configs.BookMapper;
import my.test.cbrtask.dtos.BookDto;
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
    List<BookDto> bookDtos =
        books.stream().map(BookMapper.BOOK_MAPPER::fromBook).collect(Collectors.toList());
    return bookDtos;
  }
}
