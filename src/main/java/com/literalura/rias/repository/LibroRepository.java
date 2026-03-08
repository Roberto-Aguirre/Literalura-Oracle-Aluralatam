package com.literalura.rias.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.literalura.rias.entities.Libro;
@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

	Optional<Libro> findByTituloIgnoreCaseAndAutor_Id(String titulo, Long autorId);

	@Query("SELECT l FROM Libro l LEFT JOIN FETCH l.autor")
	java.util.List<Libro> findAllWithAutor();

	@Query("SELECT l FROM Libro l LEFT JOIN FETCH l.autor WHERE LOWER(l.idioma) = LOWER(:idioma)")
	java.util.List<Libro> findAllByIdiomaIgnoreCase(String idioma);

}
