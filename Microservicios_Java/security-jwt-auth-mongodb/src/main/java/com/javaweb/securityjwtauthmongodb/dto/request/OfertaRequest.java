package com.javaweb.securityjwtauthmongodb.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class OfertaRequest {
    @Getter
    @Setter
    @NotBlank
    @Size(min = 3, max = 20)
    private String nombreUser;
    @Getter @Setter
    @NotBlank
    @Size(min = 3, max = 50)
    private String tipoDeTrabajo;
    @Getter @Setter
    @NotBlank
    @Size(min = 3, max = 20)
    private String titulo;
    @Getter @Setter
    @NotBlank
    @Size(min = 3, max = 320)
    private String descripcionDeTarea;
    @Getter @Setter
    @NotBlank
    @Size(min = 3, max = 10)
    private String fecha;
}
