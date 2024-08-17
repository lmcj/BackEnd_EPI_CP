package com.example.domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class CalculoGases {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_calculo_gases;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuario;

    @JoinColumn(nullable = false)
    private String lugar_estudio;

    @Column(nullable = false)
    private Double censo1993;

    @Column(nullable = false)
    private Double censo2005;

    @Column(nullable = false)
    private Double censo2018;

    @Column(nullable = false)
    private Double produccion_percapital_anio;

    @Column(nullable = false)
    private Integer anio_apertura;

    @Column(nullable = false)
    private Integer anio_cierre;

    @Column(nullable = false)
    private String tipo_metodo;

    @OneToMany(mappedBy = "calculo_gases")
    private Set<ResultadoCalculo> resultados_calculo;

    // Getters and Setters

    public Long getId_calculo_gases() {
        return id_calculo_gases;
    }

    public void setId_calculo_gases(Long id_calculo_gases) {
        this.id_calculo_gases = id_calculo_gases;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

    public String getTipo_metodo() {
        return tipo_metodo;
    }

    public void setTipo_metodo(String tipo_metodo) {
        this.tipo_metodo = tipo_metodo;
    }

    public Set<ResultadoCalculo> getResultados_calculo() {
        return resultados_calculo;
    }

    public void setResultados_calculo(Set<ResultadoCalculo> resultados_calculo) {
        this.resultados_calculo = resultados_calculo;
    }
}
