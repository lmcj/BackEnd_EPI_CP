package com.example.repository;

import com.example.domain.CalculoGases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalculoGasesRepository extends JpaRepository<CalculoGases, Long> {
}
