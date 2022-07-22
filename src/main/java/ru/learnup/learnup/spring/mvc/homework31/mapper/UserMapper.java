package ru.learnup.learnup.spring.mvc.homework31.mapper;

import org.springframework.stereotype.Component;
import ru.learnup.learnup.spring.mvc.homework31.entity.User;
import ru.learnup.learnup.spring.mvc.homework31.model.UserDto;
import ru.learnup.learnup.spring.mvc.homework31.view.UserView;

@Component
public class UserMapper {

    public final UserRoleMapper userRoleMapper;

    public UserMapper(UserRoleMapper userRoleMapper) {
        this.userRoleMapper = userRoleMapper;
    }

    public UserDto mapToDto(User entity) {
        return UserDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .surname(entity.getSurname())
                .patronymic(entity.getPatronymic())
                .birthday(entity.getBirthday())
                .email(entity.getEmail())
                .nickname(entity.getNickname())
                .password(entity.getPassword())
                .userRole(userRoleMapper.mapToDto(entity.getUserRole()))
                .build();
    }

    public User mapToEntity(UserDto dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setSurname(dto.getSurname());
        user.setPatronymic(dto.getPatronymic());
        user.setBirthday(dto.getBirthday());
        user.setEmail(dto.getEmail());
        user.setNickname(dto.getNickname());
        user.setPassword(dto.getPassword());
        user.setUserRole(userRoleMapper.mapToEntity(dto.getUserRole()));
        return user;
    }

    public UserView mapToView(UserDto dto) {
        UserView view = new UserView();
        view.setId(dto.getId());
        view.setName(dto.getName());
        view.setSurname(dto.getSurname());
        view.setPatronymic(dto.getPatronymic());
        view.setBirthday(dto.getBirthday());
        view.setEmail(dto.getEmail());
        view.setNickname(dto.getNickname());
        view.setPassword(dto.getPassword());
        view.setUserRole(userRoleMapper.mapToView(dto.getUserRole()));
        return view;
    }

    public UserDto mapFromView(UserView view) {
        return UserDto.builder()
                .id(view.getId())
                .name(view.getName())
                .surname(view.getSurname())
                .patronymic(view.getPatronymic())
                .birthday(view.getBirthday())
                .email(view.getEmail())
                .nickname(view.getNickname())
                .password(view.getPassword())
                .userRole(userRoleMapper.mapFromView(view.getUserRole()))
                .build();
    }

}
