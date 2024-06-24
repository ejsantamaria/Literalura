package edu.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "author")
public class AuthorEntity {

    @Id
    @Column(name = "idAuthor")
    private int id;
    @Column(unique = true, nullable = false)
    private String name;
    private int birthYear;
    private int deathYear;

}
