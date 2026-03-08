package com.literalura.rias.controllers.printControllers;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.literalura.rias.entities.Autor;
import com.literalura.rias.entities.Libro;

@Component
public class PrintController {

    Scanner scanner = new Scanner(System.in);

    public Integer menu() {
        System.out.println("Elija una opción:");
        System.out.println("1. Buscar libros por título");
        System.out.println("2. Listar libros registrados");
        System.out.println("3. Lista autores registrados");
        System.out.println("4. Lista autores vivos en un determinado año");
        System.out.println("5. Lista libro por idioma");
        System.out.println("6. salir");
        return Integer.parseInt(scanner.nextLine());
    }

    public String printBuscarLibro() {
        System.out.println("Ingresa el título del libro:");
        return scanner.nextLine();
    }

    public String printBuscarIdioma() {
        System.out.println("Ingresa el idioma del libro:");
        return scanner.nextLine();
    }

    public Integer printBuscarAnio() {
        System.out.println("Ingresa el año para buscar autores vivos:");
        return Integer.parseInt(scanner.nextLine());
    }

    public void printBook(Libro libro) {
        System.out.println("Libros encontrados con el título: ");
        System.out.println("Titulo: " + libro.getTitulo());
        String nombreAutor = libro.getAutor() != null ? libro.getAutor().getNombreAutor() : "N/A";
        System.out.println("Autor: " + nombreAutor);
        System.out.println("Idioma: " + libro.getIdioma());
        System.out.println("Numero de descargas: " + libro.getNumeroDescargas());
    }

    public void printBooks(List<Libro> libros) {

        libros.stream().forEach(libro -> {
            System.out.println("================================================");
            System.out.println("Libros encontrados con el título: ");
            System.out.println("Titulo: " + libro.getTitulo());
            String nombreAutor = libro.getAutor() != null ? libro.getAutor().getNombreAutor() : "N/A";
            System.out.println("Autor: " + nombreAutor);
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
            System.out.println("Libros escritos: ");
            autor.getLibros().forEach(libro -> System.out.println(" - " + libro.getTitulo()));
            System.out.println("================================================");
        });
    }

    public String mapLibro(String libro) {
        return libro.replace(" ", "+");
    }
}
