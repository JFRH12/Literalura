package com.aluracursos.Literalura.DTO;

import lombok.Data;

import java.util.List;

@Data
public class GutendexResult {
    private String title;
    private List<GutendexAuthor> authors;
    private List<String> languages;
    private int download_count;
}
