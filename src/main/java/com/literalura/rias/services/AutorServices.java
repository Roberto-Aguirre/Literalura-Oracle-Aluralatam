package com.literalura.rias.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.literalura.rias.entities.Autor;
import com.literalura.rias.entities.Libro;
import com.literalura.rias.repository.AutorRepository;
import com.literalura.rias.repository.LibroRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AutorServices {   

    private AutorRepository autorRepository;
    
    public List<Autor> listarAutores() {
        return autorRepository.findAll();
    }

    public String agregarAutor(Autor autor) {
        autorRepository.save(autor);
        return "Autor agregado correctamente";
    }

}
