package com.example.domain;

import jakarta.persistence.*;

@Entity
public class CalculoResiduos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_calculo_residuos;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_metodo")
    private Metodo metodo;

    @Column(nullable = false)
    private double resultado;

    // Getters and setters

    public Long getId_calculo_residuos() {
        return id_calculo_residuos;
    }

    public void setId_calculo_residuos(Long id_calculo_residuos) {
        this.id_calculo_residuos = id_calculo_residuos;
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
