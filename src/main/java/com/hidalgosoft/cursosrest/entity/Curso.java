package com.hidalgosoft.cursosrest.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "empresa_id", nullable = false)
    private Long empresaId;

    @Column(name = "nombre", nullable = false, length = 300)
    private String nombre;

    @Column(name = "objetivo", nullable = false, length = 900)
    private String objetivo;

    @Column(name = "duracion_hrs", nullable = false)
    private Integer duracionHoras;

    @Column(name = "dirigido", nullable = false, length = 2000)
    private String dirigido;

    @Column(name = "extiende_diploma", nullable = false, length = 1)
    private String extiendeDiploma;

    @Column(name = "valor_curricular", nullable = false, length = 1)
    private String valorCurricular;

    @Column(name = "activo", nullable = false, length = 1)
    private String activo;

    @Lob
    @Column(name = "logo_diploma")
    private byte[] logoDiploma;

    // Getters and Setters omitted for brevity

    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", empresaId=" + empresaId +
                ", nombre='" + nombre + '\'' +
                ", objetivo='" + objetivo + '\'' +
                ", duracionHoras=" + duracionHoras +
                ", dirigido='" + dirigido + '\'' +
                ", extiendeDiploma='" + extiendeDiploma + '\'' +
                ", valorCurricular='" + valorCurricular + '\'' +
                ", activo='" + activo + '\'' +
                '}';
    }
}

