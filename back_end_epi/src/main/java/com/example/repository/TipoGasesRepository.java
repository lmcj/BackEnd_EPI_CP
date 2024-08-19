package com.example.repository;

import com.example.domain.TipoGases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoGasesRepository extends JpaRepository<TipoGases, Long> {
    List<TipoGases> findByTipo(String tipo);
}
