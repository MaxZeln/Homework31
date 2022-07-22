package ru.learnup.learnup.spring.mvc.homework31.mapper;

import org.springframework.stereotype.Component;
import ru.learnup.learnup.spring.mvc.homework31.entity.Book;
import ru.learnup.learnup.spring.mvc.homework31.model.BookDto;
import ru.learnup.learnup.spring.mvc.homework31.view.BookView;

@Component
public class BookMapper {

    private final AuthorMapper authorMapper;

    public BookMapper(AuthorMapper authorMapper) {
        this.authorMapper = authorMapper;
    }

    public BookDto mapToDto (Book entity) {
        return BookDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .pages(entity.getPages())
                .price(entity.getPrice())
                .publishing_year(entity.getPublishing_year())
                .author(authorMapper.mapToDto(entity.getAuthor()))
                .build();
    }

    public Book mapToEntity(BookDto dto) {
        Book book = new Book();
        book.setId(dto.getId());
        book.setTitle(dto.getTitle());
        book.setPages(dto.getPages());
        book.setPrice(dto.getPrice());
        book.setPublishing_year(dto.getPublishing_year());
        book.setAuthor(authorMapper.mapToEntity(dto.getAuthor()));

        return book;
    }

    public BookView mapToView(BookDto dto) {
        BookView view = new BookView();
        view.setId(dto.getId());
        view.setTitle(dto.getTitle());
        view.setPages(dto.getPages());
        view.setPrice(dto.getPrice());
        view.setPublishing_year(dto.getPublishing_year());
        view.setAuthor(authorMapper.mapToView(dto.getAuthor()));

        return view;
    }

    public BookDto mapFromView(BookView view) {
        return BookDto.builder()
                .id(view.getId())
                .title(view.getTitle())
                .pages(view.getPages())
                .price(view.getPrice())
                .publishing_year(view.getPublishing_year())
                .author(authorMapper.mapFromView(view.getAuthor()))
                .build();
    }

}
