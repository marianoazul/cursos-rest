package com.hidalgosoft.cursosrest.controller;

import com.hidalgosoft.cursosrest.dto.CursoDTO;
import com.hidalgosoft.cursosrest.dto.GrupoUsuarioDTO;
import com.hidalgosoft.cursosrest.entity.UsuarioEntity;
import com.hidalgosoft.cursosrest.repository.UsuarioGrupoRepository;
import com.hidalgosoft.cursosrest.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @Autowired
    private UsuarioGrupoRepository usuarioGrupoRepository;

    @GetMapping("/municipio/{municipioId}")
    public List<CursoDTO> getCursosByMunicipioId(@PathVariable Long municipioId) {
        return cursoService.findCursosByMunicipioId(municipioId);
    }
    @GetMapping("/asignacion_grupo_usuario")
    public String getCursosByMunicipioId(@RequestBody GrupoUsuarioDTO grupoUsuarioDTO) {
        usuarioGrupoRepository.insertarUsuarioGrupo(grupoUsuarioDTO.getGrupoId(),grupoUsuarioDTO.getUsuarioId());
        return "cursoService.findCursosByMunicipioId(municipioId)";
    }
}