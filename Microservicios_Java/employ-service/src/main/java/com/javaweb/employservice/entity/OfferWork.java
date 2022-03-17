package com.javaweb.employservice.entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Document(collection = "offerworks")
public class OfferWork {
    @Id
    @Getter
    @Setter
    private String id;
    @Getter @Setter
    @NotBlank
    @Size(max = 20)
    private String username;
    @Getter @Setter
    @NotBlank
    @Size(max = 20)
    private String titulo;
    @Getter @Setter
    @NotBlank
    @Size(max = 50)
    private String tipotrabajo;
    //@Field("id")
    //@DBRef
    @Getter @Setter
    @NotBlank
    private Set<DemandWork> solicitudes= new HashSet<>();
    // private Work trabajo;
    @Getter @Setter
    @NotBlank
    @Size(max = 320)
    private String descripcionTarea;
    @Getter @Setter
    @NotBlank
    @Size(max = 10)
    private String fecha;
    public OfferWork() {

    }

    public OfferWork(String username, String titulo, String tipotrabajo, String descripcionTarea, String fecha) {
        this.username = username;
        this.titulo = titulo;
        this.tipotrabajo = tipotrabajo;
        this.descripcionTarea = descripcionTarea;
        this.fecha = fecha;
    }

}
