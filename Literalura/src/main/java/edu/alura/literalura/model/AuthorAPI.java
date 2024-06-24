package edu.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record AuthorAPI (
        @JsonAlias("name") String name,
        @JsonAlias("birth_year") int birthYear,
        @JsonAlias("death_year") int deathYear) {
}
