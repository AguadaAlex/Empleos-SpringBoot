package com.javaweb.employservice.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Document(collection = "works")
public class Work {
    @Id
    @Getter
    @Setter
    private String id;
    @Getter @Setter
    @NotBlank
    @Size(max = 20)
    private String nombre;
    @Getter @Setter
    @NotBlank
    @Size(max = 320)
    private String descripcion;

    public Work(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
}
