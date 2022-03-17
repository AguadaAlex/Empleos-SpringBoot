package com.javaweb.employservice.controller;

import com.javaweb.employservice.dto.CreateOffertRequest;
import com.javaweb.employservice.dto.MessageResponse;
import com.javaweb.employservice.dto.OffertRequest;
import com.javaweb.employservice.dto.UpdateOfertaRequest;
import com.javaweb.employservice.entity.OfferWork;
import com.javaweb.employservice.repository.OffertWorkRepository;
import com.javaweb.employservice.service.OffertWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.POST,RequestMethod.GET,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/task")
public class OfferController {
/*    @Autowired
    private OffertWorkRepository offertWorkRepository;*/
    @Autowired
    private OffertWorkService offertWorkService;

    // public ResponseEntity<?> save(@RequestBody OfferWork oferta){
    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody OffertRequest request){
        System.out.println(request);
        offertWorkService.save(request);
        return ResponseEntity.ok(new MessageResponse("Oferta registrada exitosamente !"));

    }
    @GetMapping
    public ResponseEntity<List<OfferWork>> getAll(){
        List<OfferWork> ofertas=offertWorkService.getAll();
        if (ofertas.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(ofertas);
    }
    @GetMapping("/byusername/{name}")
    public ResponseEntity<List<OfferWork>> getByUserId(@PathVariable("name")String name){
        List<OfferWork>  ofertas=offertWorkService.getOfertByUserName(name);
        if (ofertas.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(ofertas);
    }
    @GetMapping("/byoffert/{ofertaid}")
    public ResponseEntity<OfferWork> getByOfertaId(@PathVariable("ofertaid")String ofertaid){
        OfferWork  oferta=offertWorkService.getOfertById(ofertaid);
        if (oferta==null)
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(oferta);
    }

   @PutMapping("/{ofertaid}")
    public ResponseEntity<?> update(@PathVariable("ofertaid")String ofertaid, @Valid @RequestBody OffertRequest request){
       OfferWork  oferta=offertWorkService.getOfertById(ofertaid);
       if (oferta==null)
           return ResponseEntity.noContent().build();

      return ResponseEntity.ok(offertWorkService.updateOferta(oferta, request));
    }
    @DeleteMapping("/{ofertaid}")
    public ResponseEntity<?> delete(@PathVariable("ofertaid")String ofertaid){
        OfferWork  oferta=offertWorkService.getOfertById(ofertaid);
        if (oferta==null)
            return ResponseEntity.noContent().build();
        offertWorkService.borrarOferta(ofertaid);
        return ResponseEntity.ok(new MessageResponse("Oferta se borro exitosamente !"));
    }

}
