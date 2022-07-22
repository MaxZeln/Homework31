package ru.learnup.learnup.spring.mvc.homework31.mapper;

import org.springframework.stereotype.Component;
import ru.learnup.learnup.spring.mvc.homework31.entity.UserRole;
import ru.learnup.learnup.spring.mvc.homework31.model.UserRoleDto;
import ru.learnup.learnup.spring.mvc.homework31.view.UserRoleView;


@Component
public class UserRoleMapper {

    public UserRoleDto mapToDto(UserRole entity) {
        return UserRoleDto.builder()
                .id(entity.getId())
                .role(entity.getRole())
                .build();
    }

    public UserRole mapToEntity(UserRoleDto dto) {
        UserRole userRole = new UserRole();
        userRole.setId(dto.getId());
        userRole.setRole(dto.getRole());
        return userRole;
    }

    public UserRoleView mapToView(UserRoleDto dto) {
       UserRoleView view = new UserRoleView();
       view.setId(dto.getId());
       view.setRole(dto.getRole());
       return view;
    }

    public UserRoleDto mapFromView(UserRoleView view) {
        return UserRoleDto.builder()
                .id(view.getId())
                .role(view.getRole())
                .build();
    }
}
