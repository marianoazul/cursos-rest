package com.hidalgosoft.cursosrest.service;

import com.hidalgosoft.cursosrest.entity.UsuarioEntity;
import com.hidalgosoft.cursosrest.model.response.ApiResponse;

import java.util.List;

public interface UsuarioService {
    ApiResponse<List<UsuarioEntity>> getAll();

    ApiResponse<UsuarioEntity> findById(long id);

    ApiResponse<UsuarioEntity> save(UsuarioEntity usuario);

    ApiResponse<UsuarioEntity> update(UsuarioEntity usuario);

    ApiResponse<Object> delete(long id);
}
