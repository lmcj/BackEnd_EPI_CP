package com.example.dto;

public class EstimacionGEIDTO {
    private Long id_estimacion_gei;
    private String nombre_identificador;
    private double valor;
    private Long id_usuario;

    // Getters y Setters
    public Long getId_estimacion_gei() {
        return id_estimacion_gei;
    }

    public void setId_estimacion_gei(Long id_estimacion_gei) {
        this.id_estimacion_gei = id_estimacion_gei;
    }

    public String getNombre_identificador() {
        return nombre_identificador;
    }

    public void setNombre_identificador(String nombre_identificador) {
        this.nombre_identificador = nombre_identificador;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Long getUsuarioId() {
        return id_usuario;
    }

    public void setUsuarioId(Long id_usuario) {
        this.id_usuario = id_usuario;
    }
}
