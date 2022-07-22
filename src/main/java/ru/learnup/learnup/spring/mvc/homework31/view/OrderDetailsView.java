package ru.learnup.learnup.spring.mvc.homework31.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class OrderDetailsView {

    @JsonProperty
    private Integer id;
    @JsonProperty
    private Integer amount;
    @JsonProperty
    private Integer price;
    @JsonProperty
    private BookView book;

}
