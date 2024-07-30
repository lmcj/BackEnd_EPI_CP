package com.example.repository;

import com.example.domain.AuxiliarMetodos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuxiliarMetodosRepository extends JpaRepository<AuxiliarMetodos, Long> {
}
