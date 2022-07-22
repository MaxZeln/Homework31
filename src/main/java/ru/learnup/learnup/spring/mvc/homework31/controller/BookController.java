package ru.learnup.learnup.spring.mvc.homework31.controller;


import org.springframework.web.bind.annotation.*;
import ru.learnup.learnup.spring.mvc.homework31.mapper.BookMapper;
import ru.learnup.learnup.spring.mvc.homework31.model.BookDto;
import ru.learnup.learnup.spring.mvc.homework31.service.BookService;
import ru.learnup.learnup.spring.mvc.homework31.view.BookView;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final BookMapper bookMapper;

    public BookController(BookService bookService,
                          BookMapper bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @GetMapping
    public List<BookView> getBooks() {
        List<BookDto> books = bookService.getBooks();
        return books.stream()
                .map(bookMapper::mapToView)
                .collect(Collectors.toList());
    }

    @GetMapping("/{bookId}")
    public BookView getBook(@PathVariable(name = "bookId") int bookId) {
        BookDto book = bookService.findById(bookId);
        return bookMapper.mapToView(book);
    }

    @PostMapping
    public BookView createBook(@RequestBody BookView book) {
        BookDto dto = bookMapper.mapFromView(book);
        return bookMapper.mapToView(
                bookService.createBook(dto)
        );
    }
}
