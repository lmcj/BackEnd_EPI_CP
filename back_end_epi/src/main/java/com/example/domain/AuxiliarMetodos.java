package com.example.domain;

import jakarta.persistence.*;

@Entity
public class AuxiliarMetodos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_auxiliar_metodos;

    @ManyToOne
    @JoinColumn(name = "id_metodo")
    private Metodo metodo;

    @Column(nullable = false)
    private int año;

    @Column(nullable = false)
    private double valor;

    @Column(nullable = false, length = 100)
    private String nombre_metodo;

    // Getters and setters

    public Long getId_auxiliar_metodos() {
        return id_auxiliar_metodos;
    }

    public void setId_auxiliar_metodos(Long id_auxiliar_metodos) {
        this.id_auxiliar_metodos = id_auxiliar_metodos;
    }

    public Metodo getMetodo() {
        return metodo;
    }

    public void setMetodo(Metodo metodo) {
        this.metodo = metodo;
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