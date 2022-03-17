
package com.javaweb.employservice.entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

//@Document(collection = "demandworks")
public class DemandWork {
    @Getter @Setter
    @NotBlank
    @Size(max = 20)
    private String username;
    @Getter @Setter
    @NotBlank
    @Size(max = 20)
    private String precio;
    @Getter @Setter
    @NotBlank
    @Size(max = 320)
    private String descripcion;

    public DemandWork(String username, String precio, String descripcion) {
        this.username = username;
        this.precio = precio;
        this.descripcion = descripcion;
    }
}

