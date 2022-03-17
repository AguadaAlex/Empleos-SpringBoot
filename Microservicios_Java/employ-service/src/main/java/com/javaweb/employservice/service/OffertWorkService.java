package com.javaweb.employservice.service;

import com.javaweb.employservice.dto.CreateOffertRequest;
import com.javaweb.employservice.dto.OffertRequest;
import com.javaweb.employservice.dto.UpdateOfertaRequest;
import com.javaweb.employservice.entity.OfferWork;
import com.javaweb.employservice.entity.Work;
import com.javaweb.employservice.repository.OffertWorkRepository;
import com.javaweb.employservice.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
public class OffertWorkService {
    @Autowired
    OffertWorkRepository offertWorkRepository;
    @Autowired
    WorkRepository workRepository;
    public Boolean existeUserName(String username){
        return offertWorkRepository.existsByUsername(username);

    }

    public List<OfferWork>getAll(){
        return offertWorkRepository.findAll();

    }
    public List<OfferWork>getOfertByUserName(String name){
        List<OfferWork> ofertas= offertWorkRepository.findByUsername(name);
        return ofertas;

    }

    public OfferWork getOfertById(String id){
        return offertWorkRepository.findById(id).orElse(null);
    }

    public OfferWork save(OffertRequest request){

        OfferWork offerWork = new OfferWork(request.getNombreUser(),
                request.getTitulo(),
                request.getTipoDeTrabajo(),
                request.getDescripcionDeTarea(),
                request.getFecha());

        OfferWork oferta= offertWorkRepository.save(offerWork);
        return oferta;

    }

    public OfferWork updateOferta(OfferWork oferta, OffertRequest request){
        oferta.setUsername(request.getNombreUser());
        oferta.setTitulo(request.getTitulo());
        oferta.setTipotrabajo(request.getTipoDeTrabajo());
        oferta.setDescripcionTarea(request.getDescripcionDeTarea());
        oferta.setFecha(request.getFecha());

        return offertWorkRepository.save(oferta);

    }
    public void borrarOferta(String id){
        offertWorkRepository.deleteById(id);
    }

}
