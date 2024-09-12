package com.example.application.dto;

import java.sql.Timestamp;

public class UsuarioDTO {
    private Long id_usuario;
    private Long id_persona;
    private Long id_rol;
    private Long id_credencial;
    private String estado;
    private Timestamp fecha_registro;

    // Getters y Setters
    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Long getPersonaId() {
        return id_persona;
    }

    public void setPersonaId(Long id_persona) {
        this.id_persona = id_persona;
    }

    public Long getRolId() {
        return id_rol;
    }

    public void setRolId(Long id_rol) {
        this.id_rol = id_rol;
    }

    public Long getCredencialId() {
        return id_credencial;
    }

    public void setCredencialId(Long id_credencial) {
        this.id_credencial = id_credencial;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Timestamp getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Timestamp fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
}
