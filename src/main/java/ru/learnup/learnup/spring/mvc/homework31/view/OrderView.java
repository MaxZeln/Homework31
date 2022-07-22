package ru.learnup.learnup.spring.mvc.homework31.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OrderView {

    @JsonProperty
    private int id;
    @JsonProperty
    private int purchase_amount;
    @JsonProperty
    private UserView user;
    @JsonProperty
    private OrderDetailsView order_detail;

}
