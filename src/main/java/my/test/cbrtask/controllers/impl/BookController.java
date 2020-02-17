package my.test.cbrtask.controllers.impl;

import my.test.cbrtask.controllers.AppController;
import my.test.cbrtask.dtos.BookDto;
import my.test.cbrtask.entities.Book;
import my.test.cbrtask.services.BookService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/book")
public class BookController implements AppController<Book, BookDto> {

  private final BookService bookService;

  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @Override
  @PostMapping
  public ResponseEntity save(@RequestBody BookDto item) {
    return null;
  }

  @Override
  @PutMapping
  public ResponseEntity edit(@RequestBody BookDto dto) {
    return null;
  }

  @Override
  @DeleteMapping(value = "/id")
  public ResponseEntity<String> delete(@PathVariable Long id) {
    bookService.deleteItem(id);
    return ResponseEntity.ok("Book has been successfully deleted");
  }

  @Override
  @GetMapping(value = "/{id}")
  public ResponseEntity<BookDto> getItem(@PathVariable Long id) {
    BookDto book = bookService.getItemById(id);
    return ResponseEntity.ok(book);
  }

  @Override
  @GetMapping
  public ResponseEntity<List<BookDto>> getItemList() {
    List<BookDto> books = bookService.getItems();
    return ResponseEntity.ok(books);
  }
}
