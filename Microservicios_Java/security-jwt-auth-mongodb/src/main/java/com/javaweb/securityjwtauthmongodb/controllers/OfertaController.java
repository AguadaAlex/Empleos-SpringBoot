package com.javaweb.securityjwtauthmongodb.controllers;

import com.javaweb.securityjwtauthmongodb.dto.entityDTO.OfertaDTO;
import com.javaweb.securityjwtauthmongodb.dto.request.OfertaRequest;
import com.javaweb.securityjwtauthmongodb.dto.response.MessageResponse;
import com.javaweb.securityjwtauthmongodb.service.OfertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.POST,RequestMethod.GET,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/api/ofert")
public class OfertaController {
    @Autowired
    OfertaService ofertaService;
    //obtengo una lista ofertas para poder despue actualizarle 1 objeto o borrar o un objeto etc
    //utilizar la eficiencia del microservicio para insertar un demandante
    @GetMapping
    public ResponseEntity<List<OfertaDTO>> getAll(){
        List<OfertaDTO> ofertas=ofertaService.getAll();
        if (ofertas.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(ofertas);
    }
    @GetMapping("/bycategoria/{name}")
    public ResponseEntity<List<OfertaDTO>> getByCategoria(@PathVariable("name")String name){
        List<OfertaDTO>  ofertas=ofertaService.getByCategorias(name);
        System.out.println("ofertas");
        System.out.println("estoy");
        if (ofertas==null)
            return ResponseEntity.noContent().build();
        System.out.println("AQUI");
        return ResponseEntity.ok(ofertas);
    }
    @GetMapping("/byusername/{name}")
    public ResponseEntity<List<OfertaDTO>> getByUserId(@PathVariable("name")String name){
        List<OfertaDTO>  ofertas=ofertaService.getOfertByUserName(name);
        if (ofertas==null)
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(ofertas);
    }
    @GetMapping("/byoffert/{ofertaid}")
    public ResponseEntity<OfertaDTO> getByOfertaId(@PathVariable("ofertaid")String ofertaid){
        OfertaDTO  oferta=ofertaService.getOfertById(ofertaid);
        if (oferta==null)
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(oferta);
    }
    @PutMapping("/{ofertaid}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> update(@PathVariable("ofertaid")String ofertaid, @Valid @RequestBody OfertaRequest request){
        OfertaDTO  oferta=ofertaService.updateOferta(ofertaid,request);
        if (oferta==null)
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(oferta);
    }
    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> save(@Valid @RequestBody OfertaRequest request){
        System.out.println(request);
        ofertaService.save(request);
        return ResponseEntity.ok(new MessageResponse("Oferta registrada exitosamente !"));

    }
    @DeleteMapping("/{ofertaid}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> delete(@PathVariable("ofertaid")String ofertaid){
        OfertaDTO  oferta=ofertaService.borrarOferta(ofertaid);
        if (oferta==null)
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(new MessageResponse("Oferta se borro exitosamente !"));
    }



}
