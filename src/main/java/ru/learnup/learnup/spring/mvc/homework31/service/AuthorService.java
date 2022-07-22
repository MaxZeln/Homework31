package ru.learnup.learnup.spring.mvc.homework31.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.learnup.learnup.spring.mvc.homework31.entity.Author;
import ru.learnup.learnup.spring.mvc.homework31.mapper.AuthorMapper;
import ru.learnup.learnup.spring.mvc.homework31.model.AuthorDto;
import ru.learnup.learnup.spring.mvc.homework31.repository.AuthorRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {
    private final AuthorRepository repository;
    private final AuthorMapper authorMapper;

    public AuthorService(AuthorRepository repository,
                         AuthorMapper authorMapper) {
        this.repository = repository;
        this.authorMapper = authorMapper;
    }

    public List<AuthorDto> getAuthors() {
        return repository.findAll()
                .stream()
                .map(authorMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public AuthorDto findById(int id) {
        return authorMapper.mapToDto(repository.getById(id));
    }

    @Transactional
    public AuthorDto createAuthor(AuthorDto author) {
        Author entity = authorMapper.mapToEntity(author);
        repository.save(entity);
        return authorMapper.mapToDto(entity);
    }

    public void delete(int id) {
        Author author = repository.getById(id);
        repository.delete(author);
    }
}
