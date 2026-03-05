package com.literalura.rias.controllers.printControllers;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.literalura.rias.entities.Autor;
import com.literalura.rias.entities.Libro;
@Controller
public class PrintController {

    public void menu() {
        System.out.println("Elija una opción:");
        System.out.println("1. Buscar libros por título");
        System.out.println("2. Listar libros registrados");
        System.out.println("3. Lista autores registrados");
        System.out.println("4. Lista autores vivos en un determinado año");
        System.out.println("5. Lista libro por idioma");
        System.out.println("6. salir");
    }

    public void printBooksByTitle(Libro libro) {
        System.out.println("Libros encontrados con el título: ");
        System.out.println("Titulo: " + libro.getTitulo());
        System.out.println("Autor: " + libro.getAutor().getNombreAutor());
        System.out.println("Idioma: " + libro.getIdioma());
        System.out.println("Numero de descargas: " + libro.getNumeroDescargas());
    }

    public void printBooksByTitle(List<Libro> libros) {
        
        libros.stream().forEach(libro -> {
            System.out.println("================================================");
            System.out.println("Libros encontrados con el título: ");
            System.out.println("Titulo: " + libro.getTitulo());
            System.out.println("Autor: " + libro.getAutor().getNombreAutor());
            System.out.println("Idioma: " + libro.getIdioma());
            System.out.println("Numero de descargas: " + libro.getNumeroDescargas());
            System.out.println("================================================");
        });
    }

    public void printAutores(List<Autor> autores) {
        autores.stream().forEach(autor -> {
            System.out.println("================================================");
            System.out.println("Nombre del autor: " + autor.getNombreAutor());
            System.out.println("Fecha de nacimiento: " + autor.getAnnoNacimiento());
            System.out.println("Fecha de fallecimiento: " + autor.getAnnoFallecimiento());
            System.out.println("================================================");
        });
    }
}
