package com.example.dto;

import java.util.List;

public class TipoMedidaDTO {

    private Long id_tipo_medida;
    private String tipo;
    private List<Long> resultadosCalculoIds; // Lista de IDs de ResultadosCalculo asociados

    // Getters y Setters

    public Long getId_tipo_medida() {
        return id_tipo_medida;
    }

    public void setId_tipo_medida(Long id_tipo_medida) {
        this.id_tipo_medida = id_tipo_medida;
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
