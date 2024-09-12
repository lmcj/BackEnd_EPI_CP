package com.example.infrastructure.repository;

import com.example.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    long countByRolNombre(String nombre);
    List<Usuario> findByEstado(String estado);
}

