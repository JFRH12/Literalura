package com.aluracursos.Literalura.Service;


import com.aluracursos.Literalura.Model.Book;
import com.aluracursos.Literalura.Repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final RestTemplate restTemplate;

    public BookService(BookRepository bookRepository, RestTemplate restTemplate) {
        this.bookRepository = bookRepository;
        this.restTemplate = restTemplate;
    }

    /**
     * Listar todos los libros registrados en la base de datos.
     */
    public List<Book> listAllBooks() {
        return bookRepository.findAll();
    }

    /**
     * Buscar un libro por título.
     * Si no está en la base de datos, se busca en la API externa y se registra.
     */
    public Book findByTitle(String title) {
        Optional<Book> optionalBook = bookRepository.findByTitle(title);
        if (optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return fetchAndSaveBookFromApi(title);
        }
    }

    /**
     * Buscar libros por idioma.
     */
    public List<Book> findByLanguage(String language) {
        return bookRepository.findByLanguage(language);
    }

    /**
     * Buscar un libro en la API de GutenDex y guardarlo en la base de datos.
     */
    private Book fetchAndSaveBookFromApi(String title) {
        String apiUrl = "https://gutendex.com/books/?search=" + title;
        try {
            // Realizar la llamada a la API
            GutendexResponse response = restTemplate.getForObject(apiUrl, GutendexResponse.class);

            if (response != null && !response.getResults().isEmpty()) {
                GutendexResult result = response.getResults().get(0); // Tomar el primer resultado
                Book book = new Book(
                        null,
                        result.getTitle(),
                        result.getAuthors().isEmpty() ? "Desconocido" : result.getAuthors().get(0).getName(),
                        result.getLanguages().isEmpty() ? "Desconocido" : result.getLanguages().get(0),
                        result.getDownloadCount() // Usar un valor relacionado si aplica
                );
                return bookRepository.save(book);
            } else {
                throw new RuntimeException("No se encontraron resultados para el título: " + title);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar el libro en la API: " + e.getMessage());
        }
    }
}
