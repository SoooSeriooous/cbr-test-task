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
  public ResponseEntity<String> save(@RequestBody BookDto newBook) {
    bookService.saveBook(newBook);
    return ResponseEntity.ok("Book has been successfully saved.");
  }

  @Override
  @PutMapping
  public ResponseEntity<String> update(@RequestBody BookDto editedBook) {
    bookService.updateBook(editedBook);
    return ResponseEntity.ok("Book has been successfully updated.");
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
