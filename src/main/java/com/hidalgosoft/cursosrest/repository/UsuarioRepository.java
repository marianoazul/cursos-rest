package com.hidalgosoft.cursosrest.repository;

import com.hidalgosoft.cursosrest.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
}
