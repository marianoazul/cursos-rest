package com.hidalgosoft.cursosrest.service.impl;

import com.hidalgosoft.cursosrest.entity.UsuarioEntity;
import com.hidalgosoft.cursosrest.model.response.ApiResponse;
import com.hidalgosoft.cursosrest.repository.UsuarioGrupoRepository;
import com.hidalgosoft.cursosrest.repository.UsuarioRepository;
import com.hidalgosoft.cursosrest.service.UsuarioService;

import static com.hidalgosoft.cursosrest.utils.Messages.USER_NOT_FOUND;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final UsuarioGrupoRepository usuarioGrupoRepository;
    private final EntityManager entityManager;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, UsuarioGrupoRepository usuarioGrupoRepository, EntityManager entityManager) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioGrupoRepository = usuarioGrupoRepository;
        this.entityManager = entityManager;
    }

    @Override
    public ApiResponse<List<UsuarioEntity>> getAll() {
        return ApiResponse.ok(usuarioRepository.findAll());
    }

    @Override
    public ApiResponse<UsuarioEntity> findById(long id) {
        Optional<UsuarioEntity> usuario = usuarioRepository.findById(id);
        return usuario.map(ApiResponse::ok).orElseGet(() -> ApiResponse.error(USER_NOT_FOUND + id));
    }

    @Transactional
    @Override
    public ApiResponse<UsuarioEntity> save(UsuarioEntity usuario) {
        Long grupo = usuario.getGrupo();
        try {
//            usuario.setId(usuarioRepository.id().longValue());
            usuario.setId(ejecutarConsulta());
            usuario.setCalle("");
            usuario.setColonia(0L);
            usuario.setFechaNacimiento(new Date(1));
            usuario.setGenero("");
            usuario.setNumExt("");
            usuario.setNumInt("");
            usuario.setPais(1L);
            usuario = usuarioRepository.save(usuario);
            usuarioGrupoRepository.insertarUsuarioGrupo(grupo, usuario.getId());
            return ApiResponse.ok(usuario);
        } catch (Exception exception) {
            log.error(exception.getMessage());
            return ApiResponse.error(exception.getMessage());
        }
    }

    @Override
    public ApiResponse<UsuarioEntity> update(UsuarioEntity usuario) {
        try {
            Optional<UsuarioEntity> entity = usuarioRepository.findById(usuario.getId());
            return entity.map(
                    usuarioEntity -> ApiResponse.ok(usuarioRepository.save(usuario))
            ).orElseGet(() -> ApiResponse.error(USER_NOT_FOUND));

        } catch (Exception exception) {
            log.error(exception.getMessage());
            return ApiResponse.error(exception.getMessage());
        }
    }

    @Override
    public ApiResponse<Object> delete(long id) {
        try {
            usuarioRepository.deleteById(id);
            return ApiResponse.ok(null);
        } catch (Exception exception) {
            log.error(exception.getMessage());
            return ApiResponse.error(exception.getMessage());
        }
    }

    public Long ejecutarConsulta() {
        Query query = entityManager.createNativeQuery("SELECT COALESCE(MAX(id), 0) + 1 as id FROM usuario");
        Object result = query.getSingleResult();
        // El resultado debe ser convertido al tipo apropiado (en este caso, long)
        return result != null ? ((Number) result).longValue() : 0;
    }
}
