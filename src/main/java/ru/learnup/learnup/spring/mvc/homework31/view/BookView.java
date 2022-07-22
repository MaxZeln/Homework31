package ru.learnup.learnup.spring.mvc.homework31.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BookView {

    @JsonProperty
    private Integer id;
    @JsonProperty(required = true)
    private String title;
    @JsonProperty(required = true)
    private String publishing_year;
    @JsonProperty(required = true)
    private Integer pages;
    @JsonProperty(required = true)
    private Integer price;
    @JsonProperty(required = true)
    private AuthorView author;

}
