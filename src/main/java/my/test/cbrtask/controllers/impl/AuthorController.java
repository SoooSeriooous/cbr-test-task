package my.test.cbrtask.controllers.impl;

import my.test.cbrtask.controllers.AppController;
import my.test.cbrtask.dtos.AuthorDto;
import my.test.cbrtask.entities.Author;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/author")
public class AuthorController implements AppController<Author, AuthorDto> {
    @Override
    @PostMapping
    public ResponseEntity save(@RequestBody AuthorDto item) {
        return null;
    }

    @Override
    @PutMapping
    public ResponseEntity<AuthorDto> edit(@RequestBody AuthorDto item) {
        return null;
    }

    @Override
    @DeleteMapping
    public ResponseEntity delete(Author item) {
        return null;
    }

    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<AuthorDto> getItem(@RequestParam Long id) {
        return null;
    }

    @Override
    @GetMapping
    public ResponseEntity<List<AuthorDto>> getItemList() {
        return null;
    }
}
