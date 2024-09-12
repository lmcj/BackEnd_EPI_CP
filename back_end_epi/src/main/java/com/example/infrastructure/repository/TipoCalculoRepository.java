package com.example.infrastructure.repository;

import com.example.domain.model.TipoCalculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoCalculoRepository extends JpaRepository<TipoCalculo, Long> {
    List<TipoCalculo> findByTipo(String tipo);
}
