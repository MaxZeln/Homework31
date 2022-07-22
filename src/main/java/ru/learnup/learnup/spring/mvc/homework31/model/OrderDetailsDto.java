package ru.learnup.learnup.spring.mvc.homework31.model;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class OrderDetailsDto {

    private int id;
    private int amount;
    private int price;
    private BookDto book;

}
