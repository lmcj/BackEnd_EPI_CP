package com.example.domain;

import jakarta.persistence.*;

@Entity
public class CalculoPoblacional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_calculo_poblacional;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_metodo")
    private Metodo metodo;

    @Column(nullable = false)
    private double resultado;

    // Getters and setters

    public Long getId_calculo_poblacional() {
        return id_calculo_poblacional;
    }

    public void setId_calculo_poblacional(Long id_calculo_poblacional) {
        this.id_calculo_poblacional = id_calculo_poblacional;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Metodo getMetodo() {
        return metodo;
    }

    public void setMetodo(Metodo metodo) {
        this.metodo = metodo;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }
    
}
