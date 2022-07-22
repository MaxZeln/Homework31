package ru.learnup.learnup.spring.mvc.homework31.controller;


import org.springframework.web.bind.annotation.*;
import ru.learnup.learnup.spring.mvc.homework31.mapper.AuthorMapper;
import ru.learnup.learnup.spring.mvc.homework31.model.AuthorDto;
import ru.learnup.learnup.spring.mvc.homework31.service.AuthorService;
import ru.learnup.learnup.spring.mvc.homework31.view.AuthorView;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;
    private final AuthorMapper authorMapper;

    public AuthorController(AuthorService authorService,
                            AuthorMapper authorMapper) {
        this.authorService = authorService;
        this.authorMapper = authorMapper;
    }

    @GetMapping
    public List<AuthorView> getAuthors() {
        List<AuthorDto> authors = authorService.getAuthors();
        return authors.stream()
                .map(authorMapper::mapToView)
                .collect(Collectors.toList());
    }

    @GetMapping("/{authorId}")
    public AuthorView getAuthor(@PathVariable(name = "authorId") int authorId) {
        AuthorDto author = authorService.findById(authorId);
        return authorMapper.mapToView(author);
    }

    @PostMapping
    public AuthorView createAuthor(@RequestBody AuthorView author) {
        AuthorDto dto = authorMapper.mapFromView(author);
        return authorMapper.mapToView(
                authorService.createAuthor(dto)
        );
    }

    @PutMapping("/{authorId}")
    public AuthorView updateAuthor(@PathVariable(name = "authorId") int authorId,
                                   @RequestBody AuthorView author) {
        AuthorDto dto = authorMapper.mapFromView(author);
        return authorMapper.mapToView(
                authorService.createAuthor(dto)
        );
    }

    @DeleteMapping("/{authorId}")
    public void delete(@PathVariable(name = "authorId") int authorId) {
        authorService.delete(authorId);
    }

}
