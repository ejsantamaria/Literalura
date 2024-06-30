package edu.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;


@Data
@Entity
@Table(name = "author")
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAuthor")
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    private int birthYear;
    private int deathYear;

    @ManyToMany(mappedBy = "authors")
    private Set<BookEntity> books = new HashSet<>();

    public AuthorEntity() {

    }

    public AuthorEntity(AuthorAPI auth) {
        this.name = auth.name();
        this.birthYear = auth.birthYear();
        this.deathYear = auth.deathYear();
    }

    @Override
    public String toString() {
        return "AuthorEntity [id=" + id + ", nombre=" + name + ", año de nacimiento=" + birthYear + ", año de fallecimiento=" + deathYear + "]\n";
    }

}
