package edu.alura.literalura.service;

import edu.alura.literalura.model.BookAPI;
import edu.alura.literalura.model.ResponseAPI;

import java.util.ArrayList;

public class BookService {
    APIConsumption apiConsumption = new APIConsumption();
    DataConverter dataConverter = new DataConverter();
    static String baseURL = "http://gutendex.com/books/";

    public ArrayList<BookAPI> getBookByTitleAPI(String title) {
        var json = apiConsumption.getData(baseURL+"?search="+title);
        ResponseAPI data = dataConverter.getData(json, ResponseAPI.class);
        ArrayList<BookAPI> books = data.results();
        return books;
    }
}
