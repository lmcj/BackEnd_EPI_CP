package com.example.repository;

import com.example.domain.CalculoResiduos;
import com.example.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalculoResiduosRepository extends JpaRepository<CalculoResiduos, Long> {
    List<CalculoResiduos> findByUsuario(Usuario usuario);
}
