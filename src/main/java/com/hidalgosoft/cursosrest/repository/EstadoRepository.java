package com.hidalgosoft.cursosrest.repository;


import com.hidalgosoft.cursosrest.entity.Estado;
import com.hidalgosoft.cursosrest.entity.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

    @Query(value = "SELECT e.id, e.nombre FROM estado e " +
            "INNER JOIN municipio m ON e.id = m.estado_id " +
            "INNER JOIN servicios_georef gr ON gr.municipio_id = m.id " +
            "WHERE gr.aplicacion = :aplicacion", nativeQuery = true)
    List<Object[]> findByServiciosGeorefAplicacion(String aplicacion);

    List<Estado> findAllByPaisId(Long idPais);
}
