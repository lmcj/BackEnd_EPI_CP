package com.example.domain;

import jakarta.persistence.*;

@Entity
public class EstimacionGEI {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_estimacion_gei;

    @Column(nullable = false, length = 100)
    private String nombre_identificador;

    @Column(nullable = false)
    private double valor;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    // Getters y setters

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

