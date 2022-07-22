package ru.learnup.learnup.spring.mvc.homework31.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
public class Book_Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private int books_amount;

    @OneToOne
    private Book book;

    @Version
    @Column(name = "version")
    private Integer version;

    @Override
    public String toString() {
        return "Book_Warehouse{" +
                "id=" + id +
                ", books_amount=" + books_amount +
                ", book=" + book.getTitle() +
                '}';
    }
}