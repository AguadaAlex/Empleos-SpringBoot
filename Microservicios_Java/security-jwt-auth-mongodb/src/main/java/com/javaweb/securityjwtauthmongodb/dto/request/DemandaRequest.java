package com.javaweb.securityjwtauthmongodb.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class DemandaRequest {
    @Getter
    @Setter
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;
    @Getter @Setter
    @NotBlank
    @Size(min = 3, max = 20)
    private String precio;
    @Getter @Setter
    @NotBlank
    @Size(min = 3, max = 320)
    private String descripcion;
}
