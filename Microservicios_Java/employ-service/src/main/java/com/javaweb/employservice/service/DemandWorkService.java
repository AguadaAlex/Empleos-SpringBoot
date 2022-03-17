package com.javaweb.employservice.service;

import com.javaweb.employservice.dto.DemandRequest;
import com.javaweb.employservice.dto.OffertRequest;
import com.javaweb.employservice.entity.DemandWork;
import com.javaweb.employservice.entity.OfferWork;
//import com.javaweb.employservice.repository.DemandWorkRepository;
import com.javaweb.employservice.repository.OffertWorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class DemandWorkService {
    @Autowired
    OffertWorkRepository offertWorkRepository;
    @Autowired
    OffertWorkService offertWorkService;

    public DemandWork save(OfferWork oferta,DemandRequest request){
        Set<DemandWork> listaSolicitudes=oferta.getSolicitudes();
        //BUSCO SI EXITE SOLICITUD DEL USUARIO EN LA OFERTA
        for (DemandWork demand:listaSolicitudes){
            if (demand.getUsername().equals(request.getUsername()))
                return null;//DEVUELVO EL USURIO ENCONTRADO
            break;
        }
        //CREO UNA NUEVA SOLICITUD
        DemandWork solicitud=new DemandWork(request.getUsername(),
                request.getPrecio(),
                request.getDescripcion()
        );
        Set<DemandWork> solicitudes = oferta.getSolicitudes();
        solicitudes.add(solicitud);
        oferta.setSolicitudes(solicitudes);

        offertWorkRepository.save(oferta);
        return solicitud;

    }
    public DemandWork updateSolicitud(OfferWork oferta, DemandRequest request){
        Set<DemandWork> listaSolicitudes=oferta.getSolicitudes();
        //BUSCO SI EXITE SOLICITUD DEL USUARIO EN LA OFERTA , SI EXISTE LO ACTUALIZA
        for (DemandWork demand:listaSolicitudes){
            if (demand.getUsername().equals(request.getUsername())){
                demand.setUsername(request.getUsername());
                demand.setPrecio(request.getPrecio());
                demand.setDescripcion(request.getDescripcion());
                /*DemandWork solicitud=new DemandWork(request.getUsername(),
                        request.getPrecio(),
                        request.getDescripcion()
                );
                Set<DemandWork> solicitudes = oferta.getSolicitudes();
                solicitudes.add(solicitud);*/
                oferta.setSolicitudes(listaSolicitudes);

                 offertWorkRepository.save(oferta);
                 return demand;
        }

    }

        return null;
    }
    public DemandWork borrarSolicitud(OfferWork oferta,String username){
        Set<DemandWork> listaSolicitudes=oferta.getSolicitudes();
        //BUSCO SI EXITE SOLICITUD DEL USUARIO EN LA OFERTA , SI EXISTE LO ACTUALIZA

        for (DemandWork demand:listaSolicitudes){
            if (demand.getUsername().equals(username)){

               // Set<DemandWork> solicitudes = oferta.getSolicitudes();
                listaSolicitudes.remove(demand);
                oferta.setSolicitudes(listaSolicitudes);

                offertWorkRepository.save(oferta);
                return demand;
            }

        }
        return null;
    }
}
