package com.literalura.rias.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre_autor")
    private String nombreAutor;
    @Column(name = "anno_nacimiento")
    private Integer annoNacimiento;
    @Column(name = "anno_fallecimiento")
    private Integer annoFallecimiento;
    @OneToMany(targetEntity = Libro.class, mappedBy = "autor")
    private List<Libro> libros;

}
