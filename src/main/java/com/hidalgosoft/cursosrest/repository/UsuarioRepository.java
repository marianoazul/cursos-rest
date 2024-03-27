package com.hidalgosoft.cursosrest.repository;

import com.hidalgosoft.cursosrest.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    @Modifying
    @Query("SELECT COALESCE(MAX(id), 0) as id FROM UsuarioEntity")
    Integer id();
}
