package com.literalura.rias.controllers;

import java.util.HashMap;

import org.springframework.stereotype.Controller;

import com.literalura.rias.entities.Autor;
import com.literalura.rias.entities.Libro;
import com.literalura.rias.entities.DTOS.AuthorResponse;
import com.literalura.rias.entities.DTOS.ResponseLibros;

import jakarta.persistence.criteria.CriteriaBuilder.In;

@Controller
public class LibroMapper {
    
    public HashMap<Libro,Autor> mapResponse(ResponseLibros response){
        AuthorResponse authorResponse = response.getResults().get(0).getAuthors().get(0);
        String lenguaje = response.getResults().get(0).getLanguages().get(0);
        Autor autor = Autor.builder()
            .nombreAutor(authorResponse.getName())
            .annoNacimiento(Integer.valueOf(authorResponse.getBirth_year()))
            .annoFallecimiento(Integer.valueOf(authorResponse.getDeath_year()))
            .build();

        Libro libro = Libro.builder()
            .titulo(response.getResults().get(0).getTitle())
            .idioma(lenguaje)
            .numeroDescargas(Long.valueOf(response.getResults().get(0).getDownload_count()))
            .build();

        System.out.println(libro);
        System.out.println(autor);
        HashMap<Libro,Autor> libroAutorMap = new HashMap<>();

        return null;
            
    }
}
