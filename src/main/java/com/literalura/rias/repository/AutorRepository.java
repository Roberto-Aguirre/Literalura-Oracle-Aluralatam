package com.literalura.rias.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.literalura.rias.entities.Autor;
@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

    

}
