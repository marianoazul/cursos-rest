package com.hidalgosoft.cursosrest.entity;

import lombok.Data;
import lombok.experimental.PackagePrivate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "estado")
@PackagePrivate
@Entity
public class EstadoEntity {
    @Id
    Long id;
    @Column(name = "pais_id", nullable = false)
    Long paisID;
    @Column(name = "nombre", length = 50, nullable = false)
    String nombre;
    @Column(name = "abreviatura", length = 10, nullable = false)
    String abreviatura;
    @Column(name = "clave", nullable = false)
    Long clave;
}
