package my.test.cbrtask.configs;

import my.test.cbrtask.dtos.AuthorDto;
import my.test.cbrtask.entities.Author;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorMapper {
    AuthorMapper AUTHOR_MAPPER = Mappers.getMapper(AuthorMapper.class);
    AuthorDto fromAuthor(Author author);
    @InheritInverseConfiguration
    Author toAuthor(AuthorDto authorDto);
}
