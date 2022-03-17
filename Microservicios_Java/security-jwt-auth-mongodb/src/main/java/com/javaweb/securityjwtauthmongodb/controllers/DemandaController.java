package com.javaweb.securityjwtauthmongodb.controllers;

import com.javaweb.securityjwtauthmongodb.dto.entityDTO.DemandaDTO;
import com.javaweb.securityjwtauthmongodb.dto.entityDTO.OfertaDTO;
import com.javaweb.securityjwtauthmongodb.dto.request.ComentarioPuntosRequest;
import com.javaweb.securityjwtauthmongodb.dto.request.DemandaRequest;
import com.javaweb.securityjwtauthmongodb.dto.response.MessageResponse;
import com.javaweb.securityjwtauthmongodb.entity.Mensaje;
import com.javaweb.securityjwtauthmongodb.service.OfertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.POST,RequestMethod.GET,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/api/demanda")
public class DemandaController {
    @Autowired
    OfertaService ofertaService;

    @PostMapping("/{idoferta}")
    public ResponseEntity<?> save(@PathVariable("idoferta")String idoferta, @Valid @RequestBody DemandaRequest request){
        DemandaDTO demanda=ofertaService.saveDemanda(idoferta,request);
        if (demanda==null){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: la oferta no existe!"));
        }
        return ResponseEntity.ok(demanda);

    }
    @PutMapping("/{ofertaid}")
    public ResponseEntity<?> update(@PathVariable("ofertaid")String ofertaid, @Valid @RequestBody DemandaRequest request){
        DemandaDTO  demanda=ofertaService.updateDemanda(ofertaid,request);
        if (demanda==null){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: la oferta no existe!"));
        }
        return ResponseEntity.ok(demanda);
    }
    @DeleteMapping("/{ofertaid}/{username}")
    public ResponseEntity<?> delete(@PathVariable("ofertaid")String ofertaid,@PathVariable("username")String username){
        DemandaDTO  demanda=ofertaService.borrarDemanda(ofertaid,username);
        if (demanda==null){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: la oferta o username no existe!"));
        }
        return ResponseEntity.ok(new MessageResponse("Demanda se borro exitosamente !"));
    }



}
