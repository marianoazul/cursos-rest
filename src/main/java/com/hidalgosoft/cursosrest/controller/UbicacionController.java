package com.hidalgosoft.cursosrest.controller;


import com.hidalgosoft.cursosrest.dto.CursoDTO;
import com.hidalgosoft.cursosrest.entity.Estado;
import com.hidalgosoft.cursosrest.entity.Municipio;
import com.hidalgosoft.cursosrest.model.response.ApiResponse;
import com.hidalgosoft.cursosrest.repository.EstadoRepository;
import com.hidalgosoft.cursosrest.repository.MunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ubicacion")
public class UbicacionController {

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private MunicipioRepository municipioRepository;

    @GetMapping("/estados/{paisId}")
    public ApiResponse<List<Estado>> getEstadoByPaisId(@PathVariable Long paisId) {
        return ApiResponse.ok(estadoRepository.findAllByPaisId(paisId));
    }
    @GetMapping("/municipios/{estadoId}")
    public ApiResponse<List<Municipio>> getCursosByEstadoId(@PathVariable Long estadoId) {
        return ApiResponse.ok(municipioRepository.findByEstadoId(estadoId));
    }


}
