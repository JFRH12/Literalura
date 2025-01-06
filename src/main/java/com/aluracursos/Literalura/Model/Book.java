package com.aluracursos.Literalura.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

    @Entity
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Book {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String title;
        private String author;
        private String language;
        private int downloadCount;

        @Override
        public String toString() {
            return "Libro {" +
                    "ID: " + id +
                    ", Título: '" + title + '\'' +
                    ", Autor: '" + author + '\'' +
                    ", Idioma: '" + language + '\'' +
                    ", Descargas: " + downloadCount +
                    '}';
        }

    }


