package com.hidalgosoft.cursosrest.entity;

import lombok.Data;
import lombok.experimental.PackagePrivate;

import javax.persistence.*;
import java.sql.Date;

@Data
@Table(name = "usuario")
@PackagePrivate
@Entity
public class UsuarioEntity {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "pais_id", length = 50, nullable = false)
    Long pais;
    @Column(name = "estado_id", length = 50, nullable = false)
    Long estado;
    @Column(name = "municipio_id", length = 50, nullable = false)
    Long municipio;
    @Column(name = "colonia_id", length = 50, nullable = false)
    Long colonia;
    @Column(name = "email", length = 250, nullable = false)
    String email;
    @Column(name = "nombre", length = 150, nullable = false)
    String nombre;
    @Column(name = "paterno", length = 150, nullable = false)
    String paterno;
    @Column(name = "telefono", length = 250, nullable = false)
    String telefono;
    @Column(name = "genero", length = 50, nullable = false)
    String genero;
    @Column(name = "calle", length = 150, nullable = false)
    String calle;
    @Column(name = "num_ext", length = 20, nullable = false)
    String numExt;
    @Column(name = "num_int", length = 50, nullable = false)
    String numInt;
    @Column(name = "fecha_nacimiento", nullable = false)
    Date fechaNacimiento;
    @Column(name = "materno", length = 150)
    String materno;
}