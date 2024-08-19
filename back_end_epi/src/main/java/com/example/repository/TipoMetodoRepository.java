package com.example.repository;

import com.example.domain.TipoMetodo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoMetodoRepository extends JpaRepository<TipoMetodo, Long> {
    List<TipoMetodo> findByTipo(String tipo);
}
