package com.example.repository;

import com.example.domain.CalculoPoblacional;
import com.example.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalculoPoblacionalRepository extends JpaRepository<CalculoPoblacional, Long> {
    List<CalculoPoblacional> findByUsuario(Usuario usuario);
}
