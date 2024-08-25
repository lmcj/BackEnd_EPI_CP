package com.example.dto;

import java.util.List;

public class GrupoResultadosCalculoDTO {

    private Long tipoMetodoId;
    private Long tipoCalculoId;
    private Long tipoGasesId;
    private Long tipoMedidaId;
    private List<ResultadoSimplificadoDTO> resultados;

    // Getters y Setters

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

    public List<ResultadoSimplificadoDTO> getResultados() {
        return resultados;
    }

    public void setResultados(List<ResultadoSimplificadoDTO> resultados) {
        this.resultados = resultados;
    }
}
