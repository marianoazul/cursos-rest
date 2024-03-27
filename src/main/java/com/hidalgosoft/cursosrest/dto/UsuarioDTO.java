package com.hidalgosoft.cursosrest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.PackagePrivate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@PackagePrivate
public class UsuarioDTO {
    Long pais;
    Long estado;
    Long municipio;
    String email;
    String nombre;
    String paterno;
    String telefono;
    String materno;
    Long grupo;
}
