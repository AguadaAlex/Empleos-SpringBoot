package com.javaweb.employservice.service;

import com.javaweb.employservice.dto.OffertRequest;
import com.javaweb.employservice.dto.WorkRequest;
import com.javaweb.employservice.entity.OfferWork;
import com.javaweb.employservice.entity.Work;
import com.javaweb.employservice.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkService {
    @Autowired
    WorkRepository workRepository;

    public Work getTrabajoById(String id){
        return workRepository.findById(id).orElse(null);
    }
    public Work getTrabajoBynome(String nombre){
        return workRepository.findByNombre(nombre).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
    }
    public List<Work> getAll(){
        return workRepository.findAll();

    }
    public Work save(WorkRequest request){

        Work trabajo = new Work(request.getNombre(),
                request.getDescripcion());

        Work tipotrabajo= workRepository.save(trabajo);
        return tipotrabajo;
    }
    public Work updateTrabajo(Work trabajo, WorkRequest request){
        trabajo.setNombre(request.getNombre());
        trabajo.setDescripcion(request.getDescripcion());

        return workRepository.save(trabajo);

    }
    public void borrarTrabajo(String id){
        workRepository.deleteById(id);
    }
}
