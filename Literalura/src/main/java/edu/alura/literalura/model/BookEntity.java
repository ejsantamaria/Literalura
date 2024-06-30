package edu.alura.literalura.model;

import jakarta.persistence.*;
import lombok.Data;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "book")
public class BookEntity {
    @Id
    @Column(name = "idBook")
    private Long id;
    private String title;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> translators;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> subjects;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> languages;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> bookshelves;
    private boolean copyright;
    private int downloadCount;

    @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
    @JoinTable(name="Book_Authors", joinColumns = @JoinColumn(name = "idBook"),
            inverseJoinColumns = @JoinColumn(name = "idAuthor"))//idAuthor
    private Set<AuthorEntity> authors;

    public BookEntity() {
    }

    public BookEntity(BookAPI book) {
        this.id = (long) book.id();
        this.title = book.title();
        this.translators = book.translators();
        this.subjects = book.subjects();
        this.languages = book.languages();
        this.bookshelves = book.bookshelves();
        this.copyright = book.copyright();
        this.downloadCount = book.downloadCount();
        this.authors = new HashSet<>();
        for(AuthorAPI objAuthorAPI : book.authors()){
            this.authors.add(new AuthorEntity(objAuthorAPI));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("***** Libro guardado en la Base de Datos #").append(this.id).append(" *****\n");
        sb.append("Título: ").append(this.title).append("\n");

        sb.append("Traductores: ").append("\n");
        for (String translator : this.translators) {
            sb.append("  - ").append(translator).append("\n");
        }

        sb.append("Materias: ").append("\n");
        for (String subject : this.subjects) {
            sb.append("  - ").append(subject).append("\n");
        }

        sb.append("Estanterías: ").append("\n");
        for (String bookshelf : this.bookshelves) {
            sb.append("  - ").append(bookshelf).append("\n");
        }

        sb.append("Idiomas: ").append("\n");
        for (String language : this.languages) {
            sb.append("  - ").append(language).append("\n");
        }

        sb.append("Autores: ").append("\n");
        for (AuthorEntity author : this.authors) {
            sb.append("  - ").append(author.toString()).append("\n");
        }

        sb.append("Derechos de autor: ").append(this.copyright ? "Sí" : "No").append("\n");
        sb.append("Número de descargas: ").append(this.downloadCount).append("\n");

        return sb.toString();
    }
}
