package com.literalura.rias.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.literalura.rias.entities.Libro;
@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

}
