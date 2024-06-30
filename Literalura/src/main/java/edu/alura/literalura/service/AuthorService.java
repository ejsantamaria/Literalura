package edu.alura.literalura.service;

import edu.alura.literalura.model.AuthorEntity;
import edu.alura.literalura.repository.AuthorRepository;
import edu.alura.literalura.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    public List<AuthorEntity> findAuthors(){
        return authorRepository.findAll();
    }

    public List <AuthorEntity> findAuthorByYearALive(int year){
        return authorRepository.getAuthorsBetweenDateAlive(year);
    }
}
