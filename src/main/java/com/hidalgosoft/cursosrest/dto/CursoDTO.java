package com.hidalgosoft.cursosrest.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class CursoDTO {
    private String nombre;
    private Long id;
    private Date fechaInicio;
    private Date fechaTermino;
    private String horaInicio;
    private String horaTermino;
    private String diasDifusion;
    private Long municipioId;
}
