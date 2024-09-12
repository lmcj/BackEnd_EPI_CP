package com.example.application.dto;

import java.util.List;

public class TipoCalculoDTO {

    private Long id_tipo_calculo;
    private String tipo;
    private List<Long> resultadosCalculoIds; // Lista de IDs de ResultadosCalculo asociados

    // Getters y Setters

    public Long getId_tipo_calculo() {
        return id_tipo_calculo;
    }

    public void setId_tipo_calculo(Long id_tipo_calculo) {
        this.id_tipo_calculo = id_tipo_calculo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Long> getResultadosCalculoIds() {
        return resultadosCalculoIds;
    }

    public void setResultadosCalculoIds(List<Long> resultadosCalculoIds) {
        this.resultadosCalculoIds = resultadosCalculoIds;
    }
}
