package com.javaweb.employservice.dto;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

public class CreateOffertRequest {

    @Getter
    @Setter
    @NotBlank
    @Size(min = 3, max = 20)
    private String nombre;
    @Getter @Setter
    private Set<String> trabajo;
    @Getter @Setter
    @NotBlank
    @Size(max = 320)
    private String descripcionzona;
    @Getter @Setter
    @NotBlank
    @Size(max = 320)
    private String descripcion;
    @Getter @Setter
    @NotBlank
    @Size(max = 10)
    private String fecha;

}
