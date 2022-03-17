package com.javaweb.securityjwtauthmongodb.dto.entityDTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class DemandaDTO {
    @Getter
    @Setter
    private String username;
    @Getter @Setter
    private String precio;
    @Getter @Setter
    private String descripcion;
}
