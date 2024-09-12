package com.example.application.dto;

public class ResultadoCalculoDTO {

    private Long id_resultadocalculo;
    private Long calculoGasesId;
    private Long tipoMetodoId;
    private Long tipoCalculoId;
    private Long tipoGasesId;
    private Long tipoMedidaId;
    private Double iterador;
    private Integer anio;
    private Double resultado;

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

    public Long getTipoMetodoId() {
        return tipoMetodoId;
    }

    public void setTipoMetodoId(Long tipoMetodoId) {
        this.tipoMetodoId = tipoMetodoId;
    }

    public Long getTipoCalculoId() {
        return tipoCalculoId;
    }

    public void setTipoCalculoId(Long tipoCalculoId) {
        this.tipoCalculoId = tipoCalculoId;
    }

    public Long getTipoGasesId() {
        return tipoGasesId;
    }

    public void setTipoGasesId(Long tipoGasesId) {
        this.tipoGasesId = tipoGasesId;
    }

    public Long getTipoMedidaId() {
        return tipoMedidaId;
    }

    public void setTipoMedidaId(Long tipoMedidaId) {
        this.tipoMedidaId = tipoMedidaId;
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
