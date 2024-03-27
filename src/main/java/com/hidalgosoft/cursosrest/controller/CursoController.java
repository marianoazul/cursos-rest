package com.hidalgosoft.cursosrest.controller;

import com.hidalgosoft.cursosrest.dto.CursoDTO;
import com.hidalgosoft.cursosrest.dto.GrupoUsuarioDTO;
import com.hidalgosoft.cursosrest.entity.UsuarioEntity;
import com.hidalgosoft.cursosrest.model.response.ApiResponse;
import com.hidalgosoft.cursosrest.repository.UsuarioGrupoRepository;
import com.hidalgosoft.cursosrest.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cursos")
public class CursoController {

    private final CursoService cursoService;

    private final UsuarioGrupoRepository usuarioGrupoRepository;

    @Autowired
    public CursoController(CursoService cursoService, UsuarioGrupoRepository usuarioGrupoRepository) {
        this.cursoService = cursoService;
        this.usuarioGrupoRepository = usuarioGrupoRepository;
    }

    @GetMapping("/municipio/{municipioId}")
    public ApiResponse<List<CursoDTO>> getCursosByMunicipioId(@PathVariable Long municipioId) {
        return ApiResponse.ok(cursoService.findCursosByMunicipioId(municipioId));
    }

    @GetMapping("/asignacion_grupo_usuario")
    public ApiResponse<Object> getCursosByMunicipioId(@RequestBody GrupoUsuarioDTO grupoUsuarioDTO) {
        usuarioGrupoRepository.insertarUsuarioGrupo(grupoUsuarioDTO.getGrupoId(), grupoUsuarioDTO.getUsuarioId());
        return ApiResponse.ok(null);
    }
}