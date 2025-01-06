package com.aluracursos.Literalura;

import com.aluracursos.Literalura.Model.Book;
import com.aluracursos.Literalura.Model.Author;
import com.aluracursos.Literalura.Service.BookService;
import com.aluracursos.Literalura.Service.AuthorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;
import java.util.List;

@Component
public class ConsoleAppRunner implements CommandLineRunner {
    private final BookService bookService;
    private final AuthorService authorService;

    public ConsoleAppRunner(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== Menú de Opciones =====");
            System.out.println("1. Buscar libro por título");
            System.out.println("2. Listar libros registrados");
            System.out.println("3. Listar autores registrados");
            System.out.println("4. Listar autores vivos en un año determinado");
            System.out.println("5. Listar libros por idioma");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el título del libro: ");
                    String title = scanner.nextLine();
                    try {
                        Book book = bookService.findByTitle(title);
                        System.out.println("Libro encontrado: " + book);
                    } catch (RuntimeException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    List<Book> books = bookService.listAllBooks();
                    System.out.println("Libros registrados:");
                    books.forEach(System.out::println);
                    break;

                case 3:
                    List<Author> authors = authorService.listAllAuthors();
                    System.out.println("Autores registrados:");
                    authors.forEach(System.out::println);
                    break;

                case 4:
                    System.out.print("Ingrese el año: ");
                    int year = scanner.nextInt();
                    List<Author> aliveAuthors = authorService.findAliveInYear(year);
                    System.out.println("Autores vivos en el año " + year + ":");
                    aliveAuthors.forEach(System.out::println);
                    break;

                case 5:
                    System.out.print("Ingrese el idioma: ");
                    String language = scanner.nextLine();
                    List<Book> booksByLanguage = bookService.findByLanguage(language);
                    System.out.println("Libros en idioma " + language + ":");
                    booksByLanguage.forEach(System.out::println);
                    break;

                case 6:
                    System.out.println("¡Gracias por usar la aplicación!");
                    return;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
