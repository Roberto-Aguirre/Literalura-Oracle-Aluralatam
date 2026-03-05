package com.literalura.rias.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.literalura.rias.entities.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {

}
