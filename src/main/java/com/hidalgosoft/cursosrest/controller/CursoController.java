package com.hidalgosoft.cursosrest.controller;

import com.hidalgosoft.cursosrest.dto.CursoDTO;
import com.hidalgosoft.cursosrest.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping("/municipio/{municipioId}")
    public List<CursoDTO> getCursosByMunicipioId(@PathVariable Long municipioId) {
        return cursoService.findCursosByMunicipioId(municipioId);
    }
}