package com.javaweb.securityjwtauthmongodb.entity;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Mensaje {
    @Getter
    @Setter
    @NotBlank
    @Size(max = 20)
    private String username;
    @Getter @Setter
    @NotBlank
    @Size(max = 10)
    private String puntaje;
    @Getter @Setter
    @NotBlank
    @Size(max = 320)
    private String descripcion;
    @Getter @Setter
    @NotBlank
    @Size(max = 10)
    private String fecha;

    public Mensaje(String username, String puntaje, String descripcion, String fecha) {
        this.username = username;
        this.puntaje = puntaje;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }
}
