package ru.learnup.learnup.spring.mvc.homework31.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.learnup.learnup.spring.mvc.homework31.entity.User;
import ru.learnup.learnup.spring.mvc.homework31.mapper.UserMapper;
import ru.learnup.learnup.spring.mvc.homework31.model.UserDto;
import ru.learnup.learnup.spring.mvc.homework31.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository repository;
    private final UserMapper userMapper;


    public UserService(UserRepository repository, UserMapper userMapper) {
        this.repository = repository;
        this.userMapper = userMapper;
    }

    public List<UserDto> getUsers() {
        return repository.findAll().stream()
                .map(userMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public UserDto findById(int id) {
        return userMapper.mapToDto(repository.getById(id));
    }

    @Transactional
    public UserDto createUser(UserDto user) {
        User entity = userMapper.mapToEntity(user);
        repository.save(entity);
        return userMapper.mapToDto(entity);
    }


    public UserDto updateUser(UserDto dto) {
        User entity = repository.getById(dto.getId());
        if (entity.getName() != dto.getName()) {
            entity.setName(dto.getName());
        }
        if (entity.getSurname() != dto.getSurname() ) {
            entity.setSurname(dto.getSurname());
        }
        if (entity.getPatronymic() != dto.getPatronymic() ) {
            entity.setPatronymic(dto.getPatronymic());
        }
        if (entity.getBirthday() != dto.getBirthday() ) {
            entity.setBirthday(dto.getBirthday());
        }
        if (entity.getEmail() != dto.getEmail() ) {
            entity.setEmail(dto.getEmail());
        }
        return  userMapper.mapToDto(entity);
    }


    public void delete(int id) {
         User user = repository.getById(id);
         repository.delete(user);
    }

}
