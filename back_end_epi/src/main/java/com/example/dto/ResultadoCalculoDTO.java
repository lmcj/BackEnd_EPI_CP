package com.example.dto;

public class ResultadoCalculoDTO {

    private Long id_resultadocalculo;
    private Long calculoGasesId;
    private Long tipoCalculoId;
    private Double iterador;
    private Integer anio;
    private Double valor_aritmetico;
    private Double valor_exponencial;

    // Getters y Setters

    public Long getId_resultadocalculo() {
        return id_resultadocalculo;
    }

    public void setId_resultadocalculo(Long id_resultadocalculo) {
        this.id_resultadocalculo = id_resultadocalculo;
    }

    public Long getCalculoGasesId() {
        return calculoGasesId;
    }

    public void setCalculoGasesId(Long calculoGasesId) {
        this.calculoGasesId = calculoGasesId;
    }

    public Long getTipoCalculoId() {
        return tipoCalculoId;
    }

    public void setTipoCalculoId(Long tipoCalculoId) {
        this.tipoCalculoId = tipoCalculoId;
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
