package edu.alura.literalura.main;

import edu.alura.literalura.model.AuthorEntity;
import edu.alura.literalura.model.BookAPI;
import edu.alura.literalura.repository.AuthorRepository;
import edu.alura.literalura.repository.BookRepository;
import edu.alura.literalura.service.AuthorService;
import edu.alura.literalura.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class Menu {

    static BookService bookService;
    static AuthorService authorService;

    public Menu(BookRepository bookRepository, AuthorRepository authorRepository){
        bookService = new BookService(bookRepository, authorRepository);
        authorService = new AuthorService(authorRepository);
    }

    public void menu() {
        int option = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            showMenu();
            System.out.print("Seleccione una opción: ");
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("***El valor ingresado no es un número***\n\n");
                continue;
            }
            switch (option) {
                case 1:
                    System.out.print("Ingrese el título del libro: ");
                    String title = scanner.nextLine();
                    searchBookByTitle(title);
                    break;
                case 2:
                    listBooks();
                    break;
                case 3:
                    listAuthors();
                    break;
                case 4:
                    System.out.print("Ingrese el año: ");
                    int year = scanner.nextInt();
                    listAuthorsAliveInYear(year);
                    break;
                case 5:
                    System.out.print("Ingrese el idioma: ");
                    String language = scanner.nextLine();
                    listBooksByLanguage(language);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida, intente nuevamente.");
            }
        }while (option != 0) ;
    }

    private static void searchBookByTitle(String title) {
        boolean found = false;
        title = title.replaceAll(" ", "%20");
        ArrayList<BookAPI> books = bookService.getBookByTitleAPI(title);
        for (BookAPI book : books) {
            System.out.println(book.toString());
            found = true;
        }
        if (!found) {
            System.out.println("Libro no encontrado.");
        }
    }

    private static void listBooks() {
        System.out.println(bookService.listBooks());
    }

    private static void listAuthors() {
        List<AuthorEntity> arrayAuthors = authorService.findAuthors();
        for (AuthorEntity author : arrayAuthors) {
            System.out.println(author.toString());
        }
    }

    private static void listAuthorsAliveInYear(int year) {
        System.out.println("--- Autores vivos en el año " + year + " ---");
        List<AuthorEntity> response = authorService.findAuthorByYearALive(year);
        for (AuthorEntity author : response) {
            System.out.println(author.toString());
        }
    }

    private static void listBooksByLanguage(String language) {
        System.out.println(bookService.listBooksByLanguage(language));
    }

    private static void showMenu() {
        System.out.println("\n--- Sistema realizado por: Erick Santamaria 💻 ---");
        System.out.println("--- Menú de la Biblioteca ---");
        System.out.println("1. Buscar libro por título");
        System.out.println("2. Listar libros registrados");
        System.out.println("3. Listar autores registrados");
        System.out.println("4. Listar autores vivos en un determinado año");
        System.out.println("5. Listar libros por idioma");
        System.out.println("0. Salir");
    }

}
