package com.example.infrastructure.repository;

import com.example.domain.model.ResultadoCalculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultadoCalculoRepository extends JpaRepository<ResultadoCalculo, Long> {
    // Aquí podrías agregar métodos personalizados si lo necesitas en el futuro.
}
