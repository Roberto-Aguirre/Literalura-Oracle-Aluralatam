package com.literalura.rias.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreAutor;
    private Integer annoNacimiento;
    private Integer annoFallecimiento;
    @OneToMany(mappedBy = "autor_id")
    private List<Libro> libros;

}
