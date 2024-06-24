package edu.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ResponseAPI(
        @JsonProperty("count") int count,
        @JsonProperty("next") int next,
        @JsonProperty("previous") int previous,
        @JsonProperty("results") ArrayList<BookAPI> results
) {
}
