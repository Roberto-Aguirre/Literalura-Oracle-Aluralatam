package com.literalura.rias.controllers;

import java.util.List;

import org.springframework.stereotype.Component;

import com.literalura.rias.entities.Autor;
import com.literalura.rias.entities.Libro;
import com.literalura.rias.services.AutorServices;
import com.literalura.rias.services.LibroServices;

@Component
public class CRUDController {
    private final LibroServices libroServices;
    private final AutorServices autorServices;

    public CRUDController(LibroServices libroServices, AutorServices autorServices) {
        this.libroServices = libroServices;
        this.autorServices = autorServices;
    }

    public void putLibro(Libro libro) {

        libroServices.agregarLibro(libro);

    }

    public List<Autor> getAutores() {
        try {
            return autorServices.listarAutores();
        } catch (Exception e) {
            System.out.println("Error al obtener autores: " + e.getMessage());
            return List.of(); // Retorna una lista vacía en caso de error
        }
    }

    public List<Libro> getLibros() {
        try {
            return libroServices.listarLibros();

        } catch (Exception e) {
            System.out.println("Error al obtener libros: " + e.getMessage());
            return List.of(); // Retorna una lista vacía en caso de error
        }
    }

    public List<Autor> getAutoresAliveInYear(Integer anio) {
        try {
            return autorServices.listarAutoresVivosEnAnio(anio);

        } catch (Exception e) {
            System.out.println("Error al obtener autores vivos en el año: " + e.getMessage());
            return List.of(); // Retorna una lista vacía en caso de error
        }
    }

    public List<Libro> getLibrosByIdioma(String idioma) {
        try {
            return libroServices.listarLibrosEnIdioma(idioma);
        } catch (Exception e) {
            System.out.println("Error al obtener libros por idioma: " + e.getMessage());
            return List.of(); // Retorna una lista vacía en caso de error
        }
    }

    public Autor putAutor(Autor autor) {
        try {
           return autorServices.agregarAutor(autor);
        } catch (Exception e) {
            System.out.println("Error al agregar autor: " + e.getMessage());
            return null; // Retorna null en caso de error
        }
    }
}