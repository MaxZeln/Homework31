package ru.learnup.learnup.spring.mvc.homework31.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String publishing_year;

    @Column(nullable = false)
    private int pages;

    @Column(nullable = false)
    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    private Author author;


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publishing_year='" + publishing_year + '\'' +
                ", number_of_pages=" + pages +
                ", price=" + price +
                ", author_id=" + author.getId() +
                '}';
    }
}
