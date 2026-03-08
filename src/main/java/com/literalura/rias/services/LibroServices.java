package com.literalura.rias.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.literalura.rias.entities.Libro;
import com.literalura.rias.repository.LibroRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class LibroServices {   

    private final LibroRepository libroRepository;
    
    public List<Libro> listarLibros() {
        return libroRepository.findAllWithAutor();
    }

    public String agregarLibro(Libro libro) {
        if (libro.getAutor() == null || libro.getAutor().getId() == null) {
            return "No se pudo guardar el libro: autor no valido";
        }

        return libroRepository.findByTituloIgnoreCaseAndAutor_Id(libro.getTitulo(), libro.getAutor().getId())
                .map(libroExistente -> "El libro ya estaba registrado")
                .orElseGet(() -> {
                    libroRepository.save(libro);
                    return "Libro agregado correctamente";
                });
    }

    public List<Libro> listarLibrosEnIdioma(String idioma) {
        return libroRepository.findAllByIdiomaIgnoreCase(idioma);
    }

}
