package com.aluracursos.Literalura.Service;

import com.aluracursos.Literalura.Model.Author;
import com.aluracursos.Literalura.Repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    /**
     * Listar todos los autores registrados en la base de datos.
     */
    public List<Author> listAllAuthors() {
        return authorRepository.findAll();
    }

    /**
     * Listar autores vivos en un año específico.
     */
    public List<Author> findAliveInYear(int year) {
        return authorRepository.findAliveInYear(year);
    }
}

