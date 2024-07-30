package com.example.dto;

public class MetodoDTO {
    private Long id_metodo;
    private String nombre;
    private String tipo;

    // Getters y Setters
    public Long getId_metodo() {
        return id_metodo;
    }

    public void setId_metodo(Long id_metodo) {
        this.id_metodo = id_metodo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
