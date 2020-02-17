package my.test.cbrtask.controllers.impl;

import my.test.cbrtask.controllers.AppController;
import my.test.cbrtask.dtos.AuthorDto;
import my.test.cbrtask.entities.Author;
import my.test.cbrtask.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/author")
public class AuthorController implements AppController<Author, AuthorDto> {

  private final AuthorService authorService;

  public AuthorController(AuthorService authorService) {
    this.authorService = authorService;
  }

  @Override
  @PostMapping
  public ResponseEntity save(@RequestBody AuthorDto item) {
    return null;
  }

  @Override
  @PutMapping
  public ResponseEntity<AuthorDto> edit(@RequestBody AuthorDto newItem) {
    authorService.updateAuthor(newItem);
    return null;
  }

  @Override
  @DeleteMapping(value = "/id")
  public ResponseEntity delete(Long id) {
    authorService.deleteItem(id);
    return ResponseEntity.ok("Author has been successfully deleted");
  }

  @Override
  @GetMapping(value = "/{id}")
  public ResponseEntity<AuthorDto> getItem(@PathVariable Long id) {
    AuthorDto author = authorService.getItemById(id);
    return ResponseEntity.ok(author);
  }

  @Override
  @GetMapping
  public ResponseEntity<List<AuthorDto>> getItemList() {
    List<AuthorDto> authors = authorService.getItems();
    return ResponseEntity.ok(authors);
  }
}
