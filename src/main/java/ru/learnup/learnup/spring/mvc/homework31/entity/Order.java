package ru.learnup.learnup.spring.mvc.homework31.entity;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;

@Entity
@Table(name = "order", schema = "public")
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int purchase_amount;

    @ManyToOne
    private User user;

    @OneToOne
    private Order_Details order_details;

}
