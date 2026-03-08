package com.literalura.rias.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.literalura.rias.entities.Autor;
import com.literalura.rias.entities.Libro;
import com.literalura.rias.entities.DTOS.AuthorResponse;
import com.literalura.rias.entities.DTOS.ResponseLibros;

@Controller
public class LibroMapper {

    public Libro mapResponseLibro(ResponseLibros response) {
        if (response == null || response.getResults() == null || response.getResults().isEmpty()) {
            throw new IllegalArgumentException("No se encontraron resultados para el libro solicitado");
        }

        List<String> languages = response.getResults().get(0).getLanguages();
        String lenguaje = (languages != null && !languages.isEmpty()) ? languages.get(0) : "N/A";

        Libro libro = Libro.builder().id(null).titulo(response.getResults().get(0).getTitle()).idioma(lenguaje)
                .numeroDescargas(Long.valueOf(response.getResults().get(0).getDownload_count())).autor(null).build();

        return libro;

    }

    public Autor mapResponseAutor(ResponseLibros response) {
        if (response == null || response.getResults() == null || response.getResults().isEmpty()
                || response.getResults().get(0).getAuthors() == null
                || response.getResults().get(0).getAuthors().isEmpty()) {
            throw new IllegalArgumentException("No se encontro autor en la respuesta del libro");
        }

        AuthorResponse authorResponse = response.getResults().get(0).getAuthors().get(0);

        Autor autor = Autor.builder().id(null).nombreAutor(authorResponse.getName())
                .annoNacimiento(parseNullableInteger(authorResponse.getBirth_year()))
                .annoFallecimiento(parseNullableInteger(authorResponse.getDeath_year())).build();
        return autor;
    }

    private Integer parseNullableInteger(String value) {
        if (value == null || value.isBlank()) {
            return null;
        }

        try {
            return Integer.valueOf(value);
        } catch (NumberFormatException ex) {
            return null;
        }
    }

}
