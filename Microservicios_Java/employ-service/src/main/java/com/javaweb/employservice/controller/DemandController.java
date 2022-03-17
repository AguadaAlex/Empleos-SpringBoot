package com.javaweb.employservice.controller;

import com.javaweb.employservice.dto.DemandRequest;
import com.javaweb.employservice.dto.MessageResponse;
import com.javaweb.employservice.dto.OffertRequest;
import com.javaweb.employservice.dto.UpdateOfertaRequest;
import com.javaweb.employservice.entity.DemandWork;
import com.javaweb.employservice.entity.OfferWork;
import com.javaweb.employservice.service.DemandWorkService;
import com.javaweb.employservice.service.OffertWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.POST,RequestMethod.GET,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/solicitud")
public class DemandController {
    @Autowired
    DemandWorkService demandWorkService;
    @Autowired
    OffertWorkService offertWorkService;
    @PostMapping("/{ofertaid}")
    public ResponseEntity<?> save(@PathVariable("ofertaid")String ofertaid, @Valid @RequestBody DemandRequest request){
        OfferWork  oferta=offertWorkService.getOfertById(ofertaid);
        if (oferta==null)
            return ResponseEntity.noContent().build();
        System.out.println(request);
        DemandWork solicitud=demandWorkService.save(oferta,request);
        if (solicitud==null)
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: usted ya ha realizado una solicitud!"));
        return ResponseEntity.ok(solicitud);

    }

    @PutMapping("/{ofertaid}")
    public ResponseEntity<?> update(@PathVariable("ofertaid")String ofertaid, @Valid @RequestBody DemandRequest request){
        OfferWork  oferta=offertWorkService.getOfertById(ofertaid);
        if (oferta==null)
            return ResponseEntity.noContent().build();

        DemandWork solicitud=demandWorkService.updateSolicitud(oferta, request);

        if (solicitud==null){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: el usuario no existe!"));
        }

        return ResponseEntity.ok(solicitud);
    }

    @DeleteMapping("/{ofertaid}/{username}")
    public ResponseEntity<?> delete(@PathVariable("ofertaid")String ofertaid,@PathVariable("username")String username){
        OfferWork  oferta=offertWorkService.getOfertById(ofertaid);
        if (oferta==null)
            return ResponseEntity.noContent().build();

        DemandWork solicitud=demandWorkService.borrarSolicitud(oferta,username);
        if (solicitud==null)
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(new MessageResponse("Oferta se borro exitosamente !"));
    }

}

