package com.hidalgosoft.cursosrest.service.impl;

import com.hidalgosoft.cursosrest.entity.UsuarioEntity;
import com.hidalgosoft.cursosrest.model.response.ApiResponse;
import com.hidalgosoft.cursosrest.repository.UsuarioRepository;
import com.hidalgosoft.cursosrest.service.UsuarioService;

import static com.hidalgosoft.cursosrest.utils.Messages.USER_NOT_FOUND;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
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

    @Override
    public ApiResponse<UsuarioEntity> save(UsuarioEntity usuario) {
        try {
            return ApiResponse.ok(usuarioRepository.save(usuario));
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
}
