package ru.learnup.learnup.spring.mvc.homework31.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table
@Getter
@Setter
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String patronymic;

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
//                ", books=" + books +
                '}';
    }

    public String toName() {
        return name + " " + surname + " " + patronymic;
    }
}
