package com.example.dto;

public class CalculoResiduosDTO {
    private Long id_calculo_residuos;
    private Long id_usuario;
    private Long id_metodo;
    private double resultado;

    // Getters y Setters
    public Long getId_calculo_residuos() {
        return id_calculo_residuos;
    }

    public void setId_calculo_residuos(Long id_calculo_residuos) {
        this.id_calculo_residuos = id_calculo_residuos;
    }

    public Long getUsuarioId() {
        return id_usuario;
    }

    public void setUsuarioId(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Long getMetodoId() {
        return id_metodo;
    }

    public void setMetodoId(Long id_metodo) {
        this.id_metodo = id_metodo;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }
}
