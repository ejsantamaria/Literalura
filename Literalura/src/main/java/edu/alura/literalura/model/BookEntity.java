package edu.alura.literalura.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;

@Data
@Entity
@Table(name = "book")
public class BookEntity {
    @Id
    @Column(name = "idBook")
    private int id;
    private String title;
    @ElementCollection(fetch = FetchType.EAGER)
    private ArrayList<String> translators;
    @ElementCollection(fetch = FetchType.EAGER)
    private ArrayList<String> subjects;
    @ElementCollection(fetch = FetchType.EAGER)
    private ArrayList<String> bookshelves;
    @ElementCollection(fetch = FetchType.EAGER)
    private ArrayList<String> languages;
    private boolean copyright;
    private int downloadCount;
}
