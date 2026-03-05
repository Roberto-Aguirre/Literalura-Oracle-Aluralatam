package com.literalura.rias.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.literalura.rias.entities.Libro;
import com.literalura.rias.repository.LibroRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LibroServices {   

    private LibroRepository libroRepository;
    
    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }

    public String agregarLibro(Libro libro) {
        libroRepository.save(libro);
        return "Libro agregado correctamente";
    }

}
