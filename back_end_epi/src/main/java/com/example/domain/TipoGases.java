package com.example.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class TipoGases {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tipo_gases;

    @Column(nullable = false, length = 100)
    private String tipo;

    @OneToMany(mappedBy = "tipo_gases")
    private List<ResultadoCalculo> resultadosCalculo = new ArrayList<>();

    // Getters and setters

    public Long getId_tipo_gases() {
        return id_tipo_gases;
    }

    public void setId_tipo_gases(Long id_tipo_gases) {
        this.id_tipo_gases = id_tipo_gases;
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
