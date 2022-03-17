package com.javaweb.securityjwtauthmongodb.dto.entityDTO;

import lombok.*;

import java.util.HashSet;
import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class OfertaDTO {
    @Getter @Setter
    private String id;
    @Getter @Setter
    private String username;
    @Getter @Setter
    private String titulo;
    @Getter @Setter
    private String tipotrabajo;
    @Getter @Setter
    private Set<DemandaDTO> solicitudes= new HashSet<>();
    @Getter @Setter
    private String descripcionTarea;
    @Getter @Setter
    private String fecha;
}
