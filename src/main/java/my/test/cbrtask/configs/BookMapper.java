package my.test.cbrtask.configs;

import my.test.cbrtask.dtos.BookDto;
import my.test.cbrtask.entities.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = AuthorMapper.class)
public interface BookMapper {
  BookMapper BOOK_MAPPER = Mappers.getMapper(BookMapper.class);

  @Mapping(source = "authors", target = "authors")
  BookDto fromBook(Book book);

  Book toBook(BookDto bookDto);
}
