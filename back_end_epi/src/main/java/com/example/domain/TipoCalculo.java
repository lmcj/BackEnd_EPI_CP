package com.example.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class TipoCalculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tipo_calculo;

    @Column(nullable = false, length = 100)
    private String tipo;

    @OneToMany(mappedBy = "tipo_calculo")
    private List<ResultadoCalculo> resultadosCalculo = new ArrayList<>();

    // Getters and setters

    public Long getId_tipo_calculo() {
        return id_tipo_calculo;
    }

    public void setId_tipo_calculo(Long id_metodo) {
        this.id_tipo_calculo = id_metodo;
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
