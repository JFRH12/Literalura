package com.aluracursos.Literalura.Controller;

import com.aluracursos.Literalura.Model.Author;
import com.aluracursos.Literalura.Service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    /**
     * Listar todos los autores registrados.
     */
    @GetMapping
    public ResponseEntity<List<Author>> listAllAuthors() {
        List<Author> authors = authorService.listAllAuthors();
        return ResponseEntity.ok(authors);
    }

    /**
     * Listar autores vivos en un año específico.
     */
    @GetMapping("/alive/{year}")
    public ResponseEntity<List<Author>> findAliveInYear(@PathVariable int year) {
        List<Author> authors = authorService.findAliveInYear(year);
        return ResponseEntity.ok(authors);
    }
}

