package my.test.cbrtask.services;

import my.test.cbrtask.configs.AuthorMapper;
import my.test.cbrtask.dtos.AuthorDto;
import my.test.cbrtask.entities.Author;
import my.test.cbrtask.repositories.AuthorRepository;
import my.test.cbrtask.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {

  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;

  public AuthorService(AuthorRepository authorRepository, BookRepository bookRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
  }

  public List<AuthorDto> getItems() {
    List<Author> authors = authorRepository.findAll();
    return authors.stream()
        .map(AuthorMapper.AUTHOR_MAPPER::fromAuthor)
        .collect(Collectors.toList());
  }

  public AuthorDto getItemById(Long id) {
    Author author = authorRepository.findById(id).orElse(new Author());
    return AuthorMapper.AUTHOR_MAPPER.fromAuthor(author);
  }

  /**
   * Удаляю автора - удаляю и все его книги
   *
   * @param id идентификатор для автора
   */
  public void deleteItem(Long id) {
    bookRepository.deleteAllByAuthors(
        Collections.singletonList(authorRepository.findById(id).orElse(new Author())));
    authorRepository.deleteById(id);
  }

  public void updateAuthor(AuthorDto newItem) {
  }
}
