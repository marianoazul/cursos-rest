package com.hidalgosoft.cursosrest.controller;

import com.hidalgosoft.cursosrest.entity.UsuarioEntity;
import com.hidalgosoft.cursosrest.model.response.ApiResponse;
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
    public ResponseEntity<ApiResponse<List<UsuarioEntity>>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<UsuarioEntity>> findById(@PathVariable long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<UsuarioEntity>> save(@RequestBody UsuarioEntity usuario) {
        return ResponseEntity.ok(service.save(usuario));
    }

    @PutMapping
    public ResponseEntity<ApiResponse<UsuarioEntity>> update(@RequestBody UsuarioEntity usuario) {
        return ResponseEntity.ok(service.update(usuario));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse<Object>> delete(@PathVariable long id) {
        return ResponseEntity.ok(service.delete(id));
    }
}
