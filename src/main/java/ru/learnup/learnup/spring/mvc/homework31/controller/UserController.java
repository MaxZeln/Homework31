package ru.learnup.learnup.spring.mvc.homework31.controller;

import org.springframework.web.bind.annotation.*;
import ru.learnup.learnup.spring.mvc.homework31.mapper.UserMapper;
import ru.learnup.learnup.spring.mvc.homework31.model.UserDto;
import ru.learnup.learnup.spring.mvc.homework31.service.UserService;
import ru.learnup.learnup.spring.mvc.homework31.view.UserView;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    public List<UserView> getUsers() {
        List<UserDto> users = userService.getUsers();
        return users.stream()
                .map(userMapper::mapToView)
                .collect(Collectors.toList());
    }

    @GetMapping("/{userid}")
    public UserView getUser(@PathVariable(name = "userid") int userid) {
        UserDto user = userService.findById(userid);
        return userMapper.mapToView(user);
    }

    @PostMapping
    public UserView createUser(@RequestBody UserView user) {
        UserDto dto = userMapper.mapFromView(user);
        return userMapper.mapToView(
                userService.createUser(dto)
        );
    }

    @PutMapping("/{userid}")
    public UserView updateUser(@PathVariable(name = "userid") int userid,
                               @RequestBody UserView user) {
        UserDto dto = userMapper.mapFromView(user);
        dto = userService.updateUser(dto);
        return userMapper.mapToView(
                userService.createUser(dto)
        );
    }

    @DeleteMapping("/{userId}")
    public void delete(@PathVariable(name = "userId") int userId) {
        userService.delete(userId);
    }
}
