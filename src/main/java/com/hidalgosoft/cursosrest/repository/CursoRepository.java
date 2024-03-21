package com.hidalgosoft.cursosrest.repository;

import com.hidalgosoft.cursosrest.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    @Query(value = "SELECT c.nombre, g.id, g.fecha_inicio, g.fecha_termino, g.hora_inicio, g.hora_termino, g.dias_difusion, gm.municipio_id " +
            "FROM cursos c " +
            "INNER JOIN grupos g ON c.id = g.curso_id " +
            "INNER JOIN grupos_municipios gm ON g.id = gm.grupo_id " +
            "WHERE gm.municipio_id = :municipioId " +
            "UNION " +
            "SELECT c.nombre, g.id, g.fecha_inicio, g.fecha_termino, g.hora_inicio, g.hora_termino, g.dias_difusion, gm.municipio_id " +
            "FROM cursos c " +
            "INNER JOIN grupos g ON c.id = g.curso_id " +
            "LEFT OUTER JOIN grupos_municipios gm ON g.id = gm.grupo_id " +
            "WHERE gm.municipio_id = :municipioId " +
            "ORDER BY 8", nativeQuery = true)
    List<Object[]> findCursosByMunicipioId(@Param("municipioId") Long municipioId);
}