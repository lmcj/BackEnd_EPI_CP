package com.example.domain;

import jakarta.persistence.*;

@Entity
public class Metodo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_metodo;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String tipo;

    // Getters and setters

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
