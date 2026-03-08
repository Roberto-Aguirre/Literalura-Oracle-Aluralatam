package com.literalura.rias.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.literalura.rias.entities.Autor;
@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

	Optional<Autor> findByNombreAutorIgnoreCase(String nombreAutor);

	@Query("SELECT DISTINCT a FROM Autor a LEFT JOIN FETCH a.libros")
	List<Autor> findAllWithLibros();

	@Query("""
			SELECT DISTINCT a
			FROM Autor a
			LEFT JOIN FETCH a.libros
			WHERE a.annoNacimiento IS NOT NULL
			AND a.annoNacimiento <= :anio
			AND (a.annoFallecimiento IS NULL OR a.annoFallecimiento >= :anio)
			""")
	List<Autor> findAutoresVivosEnAnio(Integer anio);

}
