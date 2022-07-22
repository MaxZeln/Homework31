package ru.learnup.learnup.spring.mvc.homework31.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserRoleView {

    @JsonProperty
    private Integer id;
    @JsonProperty(required = true)
    private String role;


}
