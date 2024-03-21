package com.hidalgosoft.cursosrest.service;

import com.hidalgosoft.cursosrest.dto.CursoDTO;

import java.util.List;

public interface CursoService {

    public List<CursoDTO> findCursosByMunicipioId(Long municipioId);
}
