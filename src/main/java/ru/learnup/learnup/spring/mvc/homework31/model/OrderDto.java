package ru.learnup.learnup.spring.mvc.homework31.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderDto {

    private int id;
    private int purchase_amount;
    private UserDto user;
    private OrderDetailsDto order_detail;

}
