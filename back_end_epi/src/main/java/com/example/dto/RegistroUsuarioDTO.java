package com.example.dto;


import jakarta.validation.constraints.*;

public class RegistroUsuarioDTO {
    @NotNull
    private String tipo_documento;

    @NotNull
    @Pattern(regexp = "\\d{10,12}")
    private String numero_documento;

    @NotNull
    @Size(max = 50)
    @Pattern(regexp = "[a-zA-Z]+")
    private String primer_nombre;

    @NotNull
    @Size(max = 50)
    @Pattern(regexp = "[a-zA-Z]+")
    private String segundo_nombre;

    @NotNull
    @Size(max = 50)
    @Pattern(regexp = "[a-zA-Z]+")
    private String primer_apellido;

    @NotNull
    @Size(max = 50)
    @Pattern(regexp = "[a-zA-Z]+")
    private String segundo_apellido;

    @NotNull
    @Email(regexp = ".+@(gmail|hotmail|unillanos|yahoo)\\..+")
    private String email;

    @Size(max = 20)
    @Pattern(regexp = "\\d*")
    private String telefono;

    @Size(max = 250)
    private String direccion;

    @NotNull
    @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[012])-((19|20)\\d\\d)$")
    private String fecha_nacimiento;

    @NotNull
    @Size(min = 8, max = 20)
    private String contrasenia;

    @NotNull
    private Long id_rol;

    @NotNull
    @Pattern(regexp = "femenino|masculino|no binario")
    private String genero;

    private String estado;

    @NotNull
    private String programa;

    public @NotNull @Size(max = 50) @Pattern(regexp = "[a-zA-Z]+") String getPrimer_nombre() {
        return primer_nombre;
    }

    public void setPrimer_nombre(@NotNull @Size(max = 50) @Pattern(regexp = "[a-zA-Z]+") String primer_nombre) {
        this.primer_nombre = primer_nombre;
    }

    public @NotNull @Size(max = 50) @Pattern(regexp = "[a-zA-Z]+") String getSegundo_nombre() {
        return segundo_nombre;
    }

    public void setSegundo_nombre(@NotNull @Size(max = 50) @Pattern(regexp = "[a-zA-Z]+") String segundo_nombre) {
        this.segundo_nombre = segundo_nombre;
    }

    public @NotNull @Size(max = 50) @Pattern(regexp = "[a-zA-Z]+") String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(@NotNull @Size(max = 50) @Pattern(regexp = "[a-zA-Z]+") String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public @NotNull @Size(max = 50) @Pattern(regexp = "[a-zA-Z]+") String getSegundo_apellido() {
        return segundo_apellido;
    }

    public void setSegundo_apellido(@NotNull @Size(max = 50) @Pattern(regexp = "[a-zA-Z]+") String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }

    public @NotNull @Pattern(regexp = "femenino|masculino|no binario") String getGenero() {
        return genero;
    }

    public void setGenero(@NotNull @Pattern(regexp = "femenino|masculino|no binario") String genero) {
        this.genero = genero;
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

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Long getId_rol() {
        return id_rol;
    }

    public void setId_rol(Long id_rol) {
        this.id_rol = id_rol;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public @NotNull String getPrograma() { return programa; }

    public void setPrograma(@NotNull String programa) { this.programa = programa; }
}
