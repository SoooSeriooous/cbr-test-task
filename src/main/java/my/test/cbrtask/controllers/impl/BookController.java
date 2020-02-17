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

  private final BookService service;

  public BookController(BookService service) {
    this.service = service;
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
  @DeleteMapping
  public ResponseEntity delete(@RequestBody Book item) {
    return null;
  }

  @Override
  @GetMapping(value = "/{id}")
  public ResponseEntity<BookDto> getItem(@RequestParam Long id) {
    return null;
  }

  @Override
  @GetMapping
  public ResponseEntity<List<BookDto>> getItemList() {
    List<BookDto> books = service.getItems();
    return ResponseEntity.ok(books);
  }
}
