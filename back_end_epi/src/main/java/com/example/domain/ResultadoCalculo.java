package com.example.domain;

import jakarta.persistence.*;

@Entity
public class ResultadoCalculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_resultado_calculo;

    @ManyToOne
    @JoinColumn(name = "id_calculo_gases", nullable = false)
    private CalculoGases calculo_gases;

    @ManyToOne
    @JoinColumn(nullable = false)
    private TipoCalculo tipo_calculo;

    @Column(nullable = false)
    private Double iterador;

    @Column(nullable = false)
    private Integer anio;

    @Column(nullable = false)
    private Double valor_aritmetico;

    @Column(nullable = false)
    private Double valor_exponencial;

    // Getters y Setters

    public Long getId_resultado_calculo() {
        return id_resultado_calculo;
    }

    public void setId_resultado_calculo(Long id_resultado_calculo) {
        this.id_resultado_calculo = id_resultado_calculo;
    }

    public CalculoGases getCalculo_gases() {
        return calculo_gases;
    }

    public void setCalculo_gases(CalculoGases calculo_gases) {
        this.calculo_gases = calculo_gases;
    }

    public TipoCalculo getTipo_calculo() {
        return tipo_calculo;
    }

    public void setTipo_calculo(TipoCalculo tipo_calculo) {
        this.tipo_calculo = tipo_calculo;
    }

    public Double getIterador() {
        return iterador;
    }

    public void setIterador(Double iterador) {
        this.iterador = iterador;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Double getValor_aritmetico() {
        return valor_aritmetico;
    }

    public void setValor_aritmetico(Double valor_aritmetico) {
        this.valor_aritmetico = valor_aritmetico;
    }

    public Double getValor_exponencial() {
        return valor_exponencial;
    }

    public void setValor_exponencial(Double valor_exponencial) {
        this.valor_exponencial = valor_exponencial;
    }
}

