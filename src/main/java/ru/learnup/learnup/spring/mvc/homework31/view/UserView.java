package ru.learnup.learnup.spring.mvc.homework31.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class UserView {

    @JsonProperty
    private Integer id;
    @JsonProperty(required = true)
    private String name;
    @JsonProperty(required = true)
    private String surname;
    @JsonProperty(required = true)
    private String patronymic;
    @JsonProperty(required = true)
    private String birthday;
    @JsonProperty(required = true)
    private String email;
    @JsonProperty(required = true)
    private String nickname;
    @JsonProperty(required = true)
    private String password;
    @JsonProperty(required = true)
    private UserRoleView userRole;
}
