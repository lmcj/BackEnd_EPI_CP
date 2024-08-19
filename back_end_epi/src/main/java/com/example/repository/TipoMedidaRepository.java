package com.example.repository;

import com.example.domain.TipoMedida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoMedidaRepository extends JpaRepository<TipoMedida, Long> {
    List<TipoMedida> findByTipo(String tipo);
}
