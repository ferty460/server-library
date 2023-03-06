package com.example.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "books")
public class BookEntity {
    @Column(name = "book_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(min = 3, max = 35, message = "Название должно быть в пределах от 3 до 35 символов")
    private String title;

    @Length(min = 3, max = 35, message = "Имя должно быть в пределах от 3 до 35 символов")
    private String author;

    @Length(min = 3, max = 35, message = "Издательство должно быть в пределах от 3 до 35 символов")
    private String publishing;

    private int year;

    @Length(min = 3, max = 35, message = "Жанр должен быть в пределах от 3 до 35 символов")
    private String kind;
}
