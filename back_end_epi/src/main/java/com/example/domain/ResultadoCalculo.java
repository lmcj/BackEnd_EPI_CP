package com.example.domain;

import jakarta.persistence.*;

@Entity
public class ResultadoCalculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_resultado_calculo;

    @ManyToOne
    @JoinColumn(nullable = false)
    private CalculoGases calculo_gases;

    @ManyToOne
    @JoinColumn(nullable = false)
    private TipoMetodo tipo_metodo;

    @ManyToOne
    @JoinColumn(nullable = false)
    private TipoCalculo tipo_calculo;

    @ManyToOne
    @JoinColumn(nullable = false)
    private TipoGases tipo_gases;

    @ManyToOne
    @JoinColumn(nullable = false)
    private TipoMedida tipo_medida;

    @Column(nullable = false)
    private Double iterador;

    @Column(nullable = false)
    private Integer anio;

    @Column(nullable = false)
    private Double resultado;

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

    public TipoMetodo getTipo_metodo() {
        return tipo_metodo;
    }

    public void setTipo_metodo(TipoMetodo tipo_metodo) {
        this.tipo_metodo = tipo_metodo;
    }

    public TipoCalculo getTipo_calculo() {
        return tipo_calculo;
    }

    public void setTipo_calculo(TipoCalculo tipo_calculo) {
        this.tipo_calculo = tipo_calculo;
    }

    public TipoGases getTipo_gases() {
        return tipo_gases;
    }

    public void setTipo_gases(TipoGases tipo_gases) {
        this.tipo_gases = tipo_gases;
    }

    public TipoMedida getTipo_medida() {
        return tipo_medida;
    }

    public void setTipo_medida(TipoMedida tipo_medida) {
        this.tipo_medida = tipo_medida;
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

    public Double getResultado() {
        return resultado;
    }

    public void setResultado(Double resultado) {
        this.resultado = resultado;
    }
}