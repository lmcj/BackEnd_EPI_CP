package com.example.dto;

import java.util.List;

public class TipoGasesDTO {

    private Long id_tipo_gases;
    private String tipo;
    private List<Long> resultadosCalculoIds; // Lista de IDs de ResultadosCalculo asociados

    // Getters y Setters

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

    public List<Long> getResultadosCalculoIds() {
        return resultadosCalculoIds;
    }

    public void setResultadosCalculoIds(List<Long> resultadosCalculoIds) {
        this.resultadosCalculoIds = resultadosCalculoIds;
    }
}
