package com.example.domain;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_persona;

    @Column(nullable = false, length = 50)
    private String tipo_documento;

    @Column(nullable = false, length = 50)
    private String numero_documento;

    @Column(nullable = false, length = 100)
    private String primer_nombre;

    @Column(nullable = false, length = 100)
    private String segundo_nombre;

    @Column(nullable = false, length = 100)
    private String primer_apellido;

    @Column(nullable = false, length = 100)
    private String segundo_apellido;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(length = 50)
    private String telefono;

    @Column(length = 255)
    private String direccion;

    @Column(length = 255)
    private String genero;

    @Temporal(TemporalType.DATE)
    private Date fecha_nacimiento;

    // Getters and setters

    public Long getId_persona() {
        return id_persona;
    }

    public void setId_persona(Long id_persona) {
        this.id_persona = id_persona;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(String numero_documento) {
        this.numero_documento = numero_documento;
    }

    public String getPrimer_nombre() {
        return primer_nombre;
    }

    public void setPrimer_nombre(String nombres) {
        this.primer_nombre = nombres;
    }

    public String getSegundo_nombre() { return segundo_nombre; }

    public void setSegundo_nombre(String segundo_nombre) { this.segundo_nombre = segundo_nombre; }

    public String getSegundo_apellido() { return segundo_apellido; }

    public void setSegundo_apellido(String segundo_apellido) { this.segundo_apellido = segundo_apellido; }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String apellidos) {
        this.primer_apellido = apellidos;
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

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getGenero() { return genero; }

    public void setGenero(String genero) {this.genero = genero; }
}