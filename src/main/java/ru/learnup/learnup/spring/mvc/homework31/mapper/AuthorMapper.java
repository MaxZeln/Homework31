package ru.learnup.learnup.spring.mvc.homework31.mapper;

import org.springframework.stereotype.Component;
import ru.learnup.learnup.spring.mvc.homework31.entity.Author;
import ru.learnup.learnup.spring.mvc.homework31.model.AuthorDto;
import ru.learnup.learnup.spring.mvc.homework31.view.AuthorView;

@Component
public class AuthorMapper {


    public AuthorDto mapToDto (Author entity) {
        return AuthorDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .surname(entity.getSurname())
                .patronymic(entity.getPatronymic())
                .build();
    }


    public Author mapToEntity (AuthorDto dto) {
        Author author = new Author();
        author.setId(dto.getId());
        author.setName(dto.getName());
        author.setSurname(dto.getSurname());
        author.setPatronymic(dto.getPatronymic());
        return author;
    }

    public AuthorView mapToView(AuthorDto dto) {
        AuthorView view = new AuthorView();
        view.setId(dto.getId());
        view.setName(dto.getName());
        view.setSurname(dto.getSurname());
        view.setPatronymic(dto.getPatronymic());
        return view;
    }

    public AuthorDto mapFromView(AuthorView view) {
        return AuthorDto.builder()
                .id(view.getId())
                .name(view.getName())
                .surname(view.getSurname())
                .patronymic(view.getPatronymic())
                .build();
    }

}
