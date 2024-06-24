package edu.alura.literalura.main;

import edu.alura.literalura.model.BookAPI;
import edu.alura.literalura.service.BookService;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    static BookService bookService = new BookService();

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
                    //listBooks();
                    break;
                case 3:
                    //listAuthors();
                    break;
                case 4:
                    System.out.print("Ingrese el año: ");
                    int year = scanner.nextInt();
                    //listAuthorsAliveInYear(year);
                    break;
                case 5:
                    System.out.print("Ingrese el idioma: ");
                    String language = scanner.nextLine();
                    //listBooksByLanguage(language);
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

//    private static void listBooks() {
//        System.out.println("--- Lista de Libros ---");
//        for (Book book : books) {
//            System.out.println(book);
//        }
//    }
//
//    private static void listAuthors() {
//        System.out.println("--- Lista de Autores ---");
//        for (Author author : authors) {
//            System.out.println(author);
//        }
//    }
//
//    private static void listAuthorsAliveInYear(int year) {
//        System.out.println("--- Autores vivos en el año " + year + " ---");
//        for (Author author : authors) {
//            if (author.getBirthYear() <= year && (author.getDeathYear() == 0 || author.getDeathYear() >= year)) {
//                System.out.println(author);
//            }
//        }
//    }
//
//    private static void listBooksByLanguage(String language) {
//        System.out.println("--- Libros en idioma " + language + " ---");
//        for (Book book : books) {
//            if (book.getLanguages().contains(language)) {
//                System.out.println(book);
//            }
//        }
//    }

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
