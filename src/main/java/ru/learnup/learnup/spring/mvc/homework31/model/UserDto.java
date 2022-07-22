package ru.learnup.learnup.spring.mvc.homework31.model;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class UserDto {

    final private Integer id;
    final private String name;
    final private String surname;
    final private String patronymic;
    final private String birthday;
    final private String email;
    final private String nickname;
    final private String password;
    final private UserRoleDto userRole;
}
