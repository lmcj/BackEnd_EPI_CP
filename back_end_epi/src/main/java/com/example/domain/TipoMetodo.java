package com.example.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class TipoMetodo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tipo_metodo;

    @Column(nullable = false, length = 100)
    private String tipo;

    @OneToMany(mappedBy = "tipo_metodo")
    private List<ResultadoCalculo> resultadosCalculo = new ArrayList<>();

    // Getters and setters

    public Long getId_tipo_metodo() {
        return id_tipo_metodo;
    }

    public void setId_tipo_metodo(Long id_tipo_metodo) {
        this.id_tipo_metodo = id_tipo_metodo;
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


