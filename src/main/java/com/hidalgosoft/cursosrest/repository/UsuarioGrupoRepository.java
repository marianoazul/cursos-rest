package com.hidalgosoft.cursosrest.repository;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class UsuarioGrupoRepository {

    private final JdbcTemplate jdbcTemplate;

    public UsuarioGrupoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertarUsuarioGrupo(Long grupoId, Long usuarioId) {
        jdbcTemplate.update("CALL insertar_usuario_grupo(?, ?)", grupoId, usuarioId);
    }
}