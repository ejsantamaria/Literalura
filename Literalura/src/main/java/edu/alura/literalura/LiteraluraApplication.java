package edu.alura.literalura;

import edu.alura.literalura.main.Menu;
import edu.alura.literalura.repository.AuthorRepository;
import edu.alura.literalura.repository.BookRepository;
import edu.alura.literalura.service.APIConsumption;
import edu.alura.literalura.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	@Autowired
	private BookRepository _bookRepository;
	@Autowired
	private AuthorRepository _authorRepository;

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Menu menu = new Menu(_bookRepository, _authorRepository);
		menu.menu();
	}
}
