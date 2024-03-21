package com.hidalgosoft.cursosrest.service.impl;

import com.hidalgosoft.cursosrest.dto.CursoDTO;
import com.hidalgosoft.cursosrest.repository.CursoRepository;
import com.hidalgosoft.cursosrest.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;
    @Override
    public List<CursoDTO> findCursosByMunicipioId(Long municipioId) {
        List<Object[]> resultados = cursoRepository.findCursosByMunicipioId(municipioId);
        return resultados.stream().map(this::mapToCursoDTO).collect(Collectors.toList());
    }

    private CursoDTO mapToCursoDTO(Object[] resultado) {
        BigInteger bigIntegerObj = new BigInteger(String.valueOf(resultado[1]));
        CursoDTO dto = new CursoDTO();
        dto.setNombre((String) resultado[0]);
        dto.setId(bigIntegerObj.longValue());
        dto.setFechaInicio((Date) resultado[2]);
        dto.setFechaTermino((Date) resultado[3]);
        dto.setHoraInicio((String) resultado[4]);
        dto.setHoraTermino((String) resultado[5]);
        dto.setDiasDifusion((String) resultado[6]);

        bigIntegerObj=new BigInteger(String.valueOf(resultado[7]));
        dto.setMunicipioId(bigIntegerObj.longValue());
        return dto;
    }
}
