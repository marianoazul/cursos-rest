package com.hidalgosoft.cursosrest.controller;

import com.hidalgosoft.cursosrest.entity.UsuarioEntity;
import com.hidalgosoft.cursosrest.model.response.ApiResponse;
import com.hidalgosoft.cursosrest.repository.UsuarioGrupoRepository;
import com.hidalgosoft.cursosrest.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

    private final UsuarioService service;

    @Autowired
    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public ApiResponse<List<UsuarioEntity>> getAll() {
        return service.getAll();
    }

    @GetMapping("{id}")
    public ApiResponse<UsuarioEntity> findById(@PathVariable long id) {
        return service.findById(id);
    }

    @PostMapping
    public ApiResponse<UsuarioEntity> save(@RequestBody UsuarioEntity usuario) {
        return service.save(usuario);
    }

    @PutMapping
    public ApiResponse<UsuarioEntity> update(@RequestBody UsuarioEntity usuario) {
        return service.update(usuario);
    }

    @DeleteMapping("{id}")
    public ApiResponse<Object> delete(@PathVariable long id) {
        return service.delete(id);
    }
}
