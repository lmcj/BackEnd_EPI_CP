package com.example.dto;

public class AuxiliarMetodosDTO {
    private Long id_auxiliar_metodos;
    private Long id_metodo;
    private int año;
    private double valor;
    private String nombre_metodo;

    // Getters y Setters
    public Long getId_auxiliar_metodos() {
        return id_auxiliar_metodos;
    }

    public void setId_auxiliar_metodos(Long id_auxiliar_metodos) {
        this.id_auxiliar_metodos = id_auxiliar_metodos;
    }

    public Long getId_metodo() {
        return id_metodo;
    }

    public void setId_metodo(Long id_metodo) {
        this.id_metodo = id_metodo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getNombre_metodo() {
        return nombre_metodo;
    }

    public void setNombre_metodo(String nombre_metodo) {
        this.nombre_metodo = nombre_metodo;
    }
}
