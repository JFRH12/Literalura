package com.aluracursos.Literalura.Controller;

import com.aluracursos.Literalura.Model.Book;
import com.aluracursos.Literalura.Service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * Listar todos los libros registrados.
     */
    @GetMapping
    public ResponseEntity<List<Book>> listAllBooks() {
        List<Book> books = bookService.listAllBooks();
        return ResponseEntity.ok(books);
    }

    /**
     * Buscar un libro por título.
     */
    @GetMapping("/search")
    public ResponseEntity<Book> findByTitle(@RequestParam String title) {
        Book book = bookService.findByTitle(title);
        return ResponseEntity.ok(book);
    }

    /**
     * Listar libros por idioma.
     */
    @GetMapping("/language/{language}")
    public ResponseEntity<List<Book>> findByLanguage(@PathVariable String language) {
        List<Book> books = bookService.findByLanguage(language);
        return ResponseEntity.ok(books);
    }
}


