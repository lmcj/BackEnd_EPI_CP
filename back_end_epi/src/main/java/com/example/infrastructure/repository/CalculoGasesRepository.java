package com.example.infrastructure.repository;

import com.example.domain.model.CalculoGases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculoGasesRepository extends JpaRepository<CalculoGases, Long> {
}
