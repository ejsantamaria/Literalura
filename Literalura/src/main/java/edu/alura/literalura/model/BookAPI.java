package edu.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown=true)
public record BookAPI(
        @JsonAlias("id") int id,
        @JsonAlias("title") String title,
        @JsonAlias("authors") ArrayList<AuthorAPI> authors,
        @JsonAlias("translators") ArrayList<String> translators,
        @JsonAlias("subjects") ArrayList<String> subjects,
        @JsonAlias("bookshelves") ArrayList<String> bookshelves,
        @JsonAlias("languages") ArrayList<String> languages,
        @JsonAlias("copyright") boolean copyright,
        @JsonAlias("download_count") int downloadCount
) {
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("***** Libro #").append(this.id).append(" *****\n");
        sb.append("Título: ").append(this.title).append("\n");
        sb.append("Autores: ").append("\n");
        for (AuthorAPI author : this.authors) {
            sb.append("  - ").append(author.name()).append("\n");
        }
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
        sb.append("Derechos de autor: ").append(this.copyright ? "Sí" : "No").append("\n");
        sb.append("Número de descargas: ").append(this.downloadCount).append("\n");
        return sb.toString();
    }
}
