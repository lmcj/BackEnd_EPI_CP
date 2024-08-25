package com.example.dto;

import java.util.List;

public class CalculoGasesDTO {

    private Long id_calculo_gases;
    private Long usuarioId;
    private String lugar_estudio;
    private Double censo1993;
    private Double censo2005;
    private Double censo2018;
    private Double produccion_percapital_anio;
    private Integer anio_apertura;
    private Integer anio_cierre;
    private List<GrupoResultadosCalculoDTO> grupos_resultados;

    // Getters y Setters

    public Long getId_calculo_gases() {
        return id_calculo_gases;
    }

    public void setId_calculo_gases(Long id_calculo_gases) {
        this.id_calculo_gases = id_calculo_gases;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getLugar_estudio() {
        return lugar_estudio;
    }

    public void setLugar_estudio(String lugar_estudio) {
        this.lugar_estudio = lugar_estudio;
    }

    public Double getCenso1993() {
        return censo1993;
    }

    public void setCenso1993(Double censo1993) {
        this.censo1993 = censo1993;
    }

    public Double getCenso2005() {
        return censo2005;
    }

    public void setCenso2005(Double censo2005) {
        this.censo2005 = censo2005;
    }

    public Double getCenso2018() {
        return censo2018;
    }

    public void setCenso2018(Double censo2018) {
        this.censo2018 = censo2018;
    }

    public Double getProduccion_percapital_anio() {
        return produccion_percapital_anio;
    }

    public void setProduccion_percapital_anio(Double produccion_percapital_anio) {
        this.produccion_percapital_anio = produccion_percapital_anio;
    }

    public Integer getAnio_apertura() {
        return anio_apertura;
    }

    public void setAnio_apertura(Integer anio_apertura) {
        this.anio_apertura = anio_apertura;
    }

    public Integer getAnio_cierre() {
        return anio_cierre;
    }

    public void setAnio_cierre(Integer anio_cierre) {
        this.anio_cierre = anio_cierre;
    }

    public List<GrupoResultadosCalculoDTO> getGrupos_resultados() {
        return grupos_resultados;
    }

    public void setGrupos_resultados(List<GrupoResultadosCalculoDTO> grupos_resultados) {
        this.grupos_resultados = grupos_resultados;
    }
}
