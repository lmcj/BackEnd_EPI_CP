package com.example.dto;

public class CalculoPoblacionalDTO {
    private Long id_calculo_poblacional;
    private Long id_usuario;
    private Long id_metodo;
    private double resultado;

    // Getters y Setters
    public Long getId_calculo_poblacional() {
        return id_calculo_poblacional;
    }

    public void setId_calculo_poblacional(Long id_calculo_poblacional) {
        this.id_calculo_poblacional = id_calculo_poblacional;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Long getId_metodo() {
        return id_metodo;
    }

    public void setId_metodo(Long id_metodo) {
        this.id_metodo = id_metodo;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }
}
