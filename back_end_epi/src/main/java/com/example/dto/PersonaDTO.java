package com.example.dto;

import java.util.Date;

public class PersonaDTO {
    private Long id_persona;
    private String tipo_documentos;
    private String numero_documento;
    private String nombres;
    private String apellidos;
    private String email;
    private String telefono;
    private String direccion;
    private String genero;
    private String programa;
    private Date fecha_nacimiento;

    // Getters y Setters
    public Long getId_persona() {
        return id_persona;
    }

    public void setId_persona(Long id_persona) {
        this.id_persona = id_persona;
    }

    public String getTipo_documentos() {
        return tipo_documentos;
    }

    public void setTipo_documentos(String tipo_documentos) {
        this.tipo_documentos = tipo_documentos;
    }

    public String getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(String numero_documento) {
        this.numero_documento = numero_documento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public String getGenero() { return genero; }

    public void setGenero(String genero) { this.genero = genero; }

    public String getPrograma() { return programa;}

    public void setPrograma(String programa) { this.programa = programa; }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
}
