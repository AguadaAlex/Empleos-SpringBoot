package com.javaweb.employservice.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class WorkRequest {
    @Getter
    @Setter
    @NotBlank
    @Size(min = 3, max = 20)
    private String nombre;
    @Getter @Setter
    @NotBlank
    @Size(min = 3, max = 320)
    private String descripcion;
}
