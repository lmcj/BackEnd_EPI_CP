package com.example.repository;

import com.example.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
    boolean existsByEmail(String email);
    boolean existsByNumeroDocumento(String numeroDocumento);
}
