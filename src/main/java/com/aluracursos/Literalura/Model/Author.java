package com.aluracursos.Literalura.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int birthYear;
    private Integer deathYear; // Puede ser null si el autor está vivo

    @Override
    public String toString() {
        return "Autor {" +
                "ID: " + id +
                ", Nombre: '" + name + '\'' +
                ", Año de Nacimiento: " + birthYear +
                ", Año de Fallecimiento: " + (deathYear == null ? "Vivo" : deathYear) +
                '}';
    }

}