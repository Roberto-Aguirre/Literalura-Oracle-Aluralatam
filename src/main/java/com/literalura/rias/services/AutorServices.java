package com.literalura.rias.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.literalura.rias.entities.Autor;
import com.literalura.rias.repository.AutorRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AutorServices {

    private AutorRepository autorRepository;

    public List<Autor> listarAutores() {
        return autorRepository.findAllWithLibros();
    }

    public Autor agregarAutor(Autor autor) {
        return autorRepository.findByNombreAutorIgnoreCase(autor.getNombreAutor())
                .orElseGet(() -> autorRepository.save(autor));
    }

    public List<Autor> listarAutoresVivosEnAnio(Integer anio) {
        return autorRepository.findAutoresVivosEnAnio(anio);
    }

}
