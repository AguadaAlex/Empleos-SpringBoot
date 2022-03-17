package com.javaweb.employservice.controller;

import com.javaweb.employservice.dto.MessageResponse;
import com.javaweb.employservice.dto.OffertRequest;
import com.javaweb.employservice.dto.WorkRequest;
import com.javaweb.employservice.entity.OfferWork;
import com.javaweb.employservice.entity.Work;
import com.javaweb.employservice.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.POST,RequestMethod.GET,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/work")
public class WorkController {
    @Autowired
    WorkService workService;
    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody WorkRequest request){
        System.out.println(request);
        Work trabajo=workService.getTrabajoBynome(request.getNombre());
        if (trabajo==null)
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: no existe oferta!"));
        workService.save(request);
        return ResponseEntity.ok(new MessageResponse("trabajo registrado exitosamente !"));

    }
    @GetMapping
    public ResponseEntity<List<Work>> getAll(){
        List<Work> trabajos=workService.getAll();
        if (trabajos.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(trabajos);
    }
    @GetMapping("/bytask/{taskid}")
    public ResponseEntity<Work> getById(@PathVariable("taskid")String taskid){
        Work trabajo=workService.getTrabajoById(taskid);
        if (trabajo==null)
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(trabajo);
    }
    @PutMapping("/{taskid}")
    public ResponseEntity<?> update(@PathVariable("taskid")String taskid, @Valid @RequestBody WorkRequest request){
        Work  trabajo=workService.getTrabajoById(taskid);
        if (trabajo==null)
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: no existe el trabajo!"));

        return ResponseEntity.ok(workService.updateTrabajo(trabajo, request));
    }
    @DeleteMapping("/{taskid}")
    public ResponseEntity<?> delete(@PathVariable("taskid")String taskid){
        Work  trabajo=workService.getTrabajoById(taskid);
        if (trabajo==null)
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: no existe el trabajo!"));
        workService.borrarTrabajo(taskid);
        return ResponseEntity
                .badRequest()
                .body(new MessageResponse("el trabajo se borro exitosamente !"));
    }
}
