package ru.learnup.learnup.spring.mvc.homework31.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AuthorView {

    @JsonProperty
    private int id;
    @JsonProperty(required = true)
    private String name;
    @JsonProperty(required = true)
    private String surname;
    @JsonProperty(required = true)
    private String patronymic;
}
