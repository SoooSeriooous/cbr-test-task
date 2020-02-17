package my.test.cbrtask.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "AUTHOR")
public class Author {

  @Id
  @Column(name = "ID")
  private Long id;

  @Column(name = "NAME", nullable = false)
  private String name;

  @Column(name = "SURNAME", nullable = false)
  private String surname;

  @Column(name = "BIRTH_DATE")
  private LocalDate birthDate;

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "authors")
  private List<Book> books;

  public Author() {}

  public List<Book> getBook() {
    return books;
  }

  public void setBook(List<Book> books) {
    this.books = books;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
