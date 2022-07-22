package ru.learnup.learnup.spring.mvc.homework31.model;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class AuthorDto {

    private int id;
    private String name;
    private String surname;
    private String patronymic;

}
