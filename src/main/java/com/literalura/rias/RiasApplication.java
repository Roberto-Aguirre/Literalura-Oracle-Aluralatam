package com.literalura.rias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.literalura.rias.controllers.HttpController;
import com.literalura.rias.controllers.CRUDController;
import com.literalura.rias.controllers.printControllers.PrintController;
import com.literalura.rias.entities.Autor;
import com.literalura.rias.entities.Libro;

import java.util.HashMap;

@SpringBootApplication
public class RiasApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(RiasApplication.class, args);

        HttpController httpController = context.getBean(HttpController.class);
        CRUDController crudController = context.getBean(CRUDController.class);
        PrintController printController = context.getBean(PrintController.class);

        int opcion = -1;

        System.out.println("================================================");
        System.out.println("¡BIENVENIDO A LITERALURA!");
        System.out.println("================================================");

        while (opcion != 6) {
            opcion = printController.menu();
            try {
                switch (opcion) {
                case 1:
                    String titulo = printController.printBuscarLibro();
                    HashMap<Libro, Autor> dataEncontrada = httpController.getInfo(titulo);

                    if (!dataEncontrada.isEmpty()) {
                        Autor autor = dataEncontrada.values().iterator().next();
                        autor = crudController.putAutor(autor);
                        Libro libro = dataEncontrada.keySet().iterator().next();
                        libro.setAutor(autor);
                        crudController.putLibro(libro);
                    } else {
                        System.out.println("No se encontró información para el libro: " + titulo);
                    }
                    break;
                case 2:
                    printController.printBooks(crudController.getLibros());
                    break;
                case 3:
                    printController.printAutores(crudController.getAutores());
                    break;
                case 4:
                    Integer anio = printController.printBuscarAnio();
                    printController.printAutores(crudController.getAutoresAliveInYear(anio));
                    break;
                case 5:
                    String idioma = printController.printBuscarIdioma();
                    printController.printBooks(crudController.getLibrosByIdioma(idioma));
                    break;
                case 6:
                    System.out.println("Cerrando la aplicación... ¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida.");
                }
            } catch (Exception e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
            }
        }
    };

}