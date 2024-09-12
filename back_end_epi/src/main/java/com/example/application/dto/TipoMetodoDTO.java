package com.example.application.dto;

import java.util.List;

public class TipoMetodoDTO {

    private Long id_tipo_metodo;
    private String tipo;
    private List<Long> resultadosCalculoIds; // Lista de IDs de ResultadosCalculo asociados

    // Getters y Setters

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

    public List<Long> getResultadosCalculoIds() {
        return resultadosCalculoIds;
    }

    public void setResultadosCalculoIds(List<Long> resultadosCalculoIds) {
        this.resultadosCalculoIds = resultadosCalculoIds;
    }
}
