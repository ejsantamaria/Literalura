package edu.alura.literalura.service;

import edu.alura.literalura.model.*;
import edu.alura.literalura.repository.AuthorRepository;
import edu.alura.literalura.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;

@Service
public class BookService {

    APIConsumption apiConsumption = new APIConsumption();
    DataConverter dataConverter = new DataConverter();
    static String baseURL = "http://gutendex.com/books/";

    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository){
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public ArrayList<BookAPI> getBookByTitleAPI(String title) {
        var json = apiConsumption.getData(baseURL+"?search="+title);
        ResponseAPI data = dataConverter.getData(json, ResponseAPI.class);
        ArrayList<BookAPI> books = data.results();
        for (BookAPI book : books) {
            try{
                if(bookRepository.existsById((long) book.id())){
                    System.out.println("El libro con ID " + book.id() + " ya se encuentra registrado en la base de datos");
                }else{
                    saveBook(book);
                }
            }catch (DataAccessException e) {
                System.out.println("Error al acceder a la base de datos para el libro con ID " + book.id());
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Error inesperado al procesar el libro con ID " + book.id());
                System.out.println(e.getMessage());
            }
        }
        return books;
    }

    public void saveBook(BookAPI bookAPI) {
        BookEntity bookEntity = new BookEntity(bookAPI);
        Set<AuthorEntity> authors = new HashSet<>();
        for (AuthorEntity authorEntity : bookEntity.getAuthors()) {
            AuthorEntity objAuthorEntity;
            if(!authorRepository.existsByName(authorEntity.getName())){
                objAuthorEntity = authorRepository.save(authorEntity);
            }
            else{
                objAuthorEntity = authorRepository.findByName(authorEntity.getName());
            }
            authors.add(objAuthorEntity);
        }
        bookEntity.setAuthors(authors);
        bookRepository.save(bookEntity);
    }

    public String listBooks(){
        List<BookEntity> listBooks = bookRepository.findAll();
        StringBuilder sb = new StringBuilder();
        for (BookEntity book : listBooks) {
            sb.append(book.toString());
        }
        return sb.toString();
    }

    public String listBooksByLanguage(String language){
        List<BookEntity> listBooks = bookRepository.findAllByLanguagesContainsIgnoreCase(language);
        StringBuilder sb = new StringBuilder();
        for (BookEntity book : listBooks) {
            sb.append(book.toString());
        }
        return sb.toString();
    }

}
