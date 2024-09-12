package com.example.domain.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class TipoMedida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tipo_medida;

    @Column(nullable = false, length = 100)
    private String tipo;

    @OneToMany(mappedBy = "tipo_medida")
    private List<ResultadoCalculo> resultadosCalculo = new ArrayList<>();

    // Getters and setters

    public Long getId_tipo_medida() {
        return id_tipo_medida;
    }

    public void setId_tipo_medida(Long id_tipo_medida) {
        this.id_tipo_medida = id_tipo_medida;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<ResultadoCalculo> getResultadosCalculo() {
        return resultadosCalculo;
    }

    public void setResultadosCalculo(List<ResultadoCalculo> resultadosCalculo) {
        this.resultadosCalculo = resultadosCalculo;
    }

}

