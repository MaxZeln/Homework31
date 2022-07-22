package ru.learnup.learnup.spring.mvc.homework31.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "order_details", schema = "public")
@Getter
@Setter
public class Order_Details {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int amount;

    @Column(nullable = false)
    private int price;

    @OneToOne
    private Book book;

}
