package com.javaweb.securityjwtauthmongodb.controllers;

import com.javaweb.securityjwtauthmongodb.dto.request.ComentarioPuntosRequest;
import com.javaweb.securityjwtauthmongodb.entity.Mensaje;
import com.javaweb.securityjwtauthmongodb.service.OfertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.POST,RequestMethod.GET,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/api/punycoment")
public class ComentarioController {
    @Autowired
    OfertaService ofertaService;


    @GetMapping("/{nameuser}")
    public ResponseEntity<?> getAll(@PathVariable("nameuser")String nameuser){
        List<Mensaje> ofertas=ofertaService.getAllMensajes(nameuser);
        if (ofertas.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(ofertas);
    }
    @PostMapping("/{nameuser}")
    public ResponseEntity<?> save(@PathVariable("nameuser")String nameuser, @Valid @RequestBody ComentarioPuntosRequest request){
        Mensaje mensaje=ofertaService.saveComentarioPuntos(nameuser,request);
        return ResponseEntity.ok(mensaje);

    }
}
