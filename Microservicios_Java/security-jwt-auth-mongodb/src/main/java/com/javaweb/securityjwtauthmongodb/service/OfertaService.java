package com.javaweb.securityjwtauthmongodb.service;

import com.javaweb.securityjwtauthmongodb.dto.entityDTO.DemandaDTO;
import com.javaweb.securityjwtauthmongodb.dto.entityDTO.OfertaDTO;
import com.javaweb.securityjwtauthmongodb.dto.request.ComentarioPuntosRequest;
import com.javaweb.securityjwtauthmongodb.dto.request.DemandaRequest;
import com.javaweb.securityjwtauthmongodb.dto.request.OfertaRequest;
import com.javaweb.securityjwtauthmongodb.entity.Mensaje;
import com.javaweb.securityjwtauthmongodb.entity.User;
import com.javaweb.securityjwtauthmongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class OfertaService {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    UserRepository userRepository;
    private static final String API_DEMANDA_OFERTA="http://localhost:8081/solicitud/";
    private static final String GET_ALL_API="http://localhost:8081/task/";
    private static final String GET_BY_USERNAME_API="http://localhost:8081/task/byusername/";
    private static final String GET_BY_OFERT_BY_ID_API="http://localhost:8081/task/byoffert/";
    public List<OfertaDTO> getAll(){
        ResponseEntity<List<OfertaDTO>> ofertasResponseEntity = restTemplate.exchange(GET_ALL_API, HttpMethod.GET, null, new ParameterizedTypeReference<List<OfertaDTO>>() {
        });
        List<OfertaDTO> listaOfertas = ofertasResponseEntity.getBody();
        System.out.println(listaOfertas);
        return listaOfertas;

    }
    public List<OfertaDTO>getOfertByUserName(String name){
        ResponseEntity<List<OfertaDTO>> ofertasResponseEntity = restTemplate.exchange(GET_BY_USERNAME_API+name, HttpMethod.GET, null, new ParameterizedTypeReference<List<OfertaDTO>>() {
        });
        System.out.println("exchange = " + ofertasResponseEntity + "; response body = " + ofertasResponseEntity.getBody());
        List<OfertaDTO> listaOfertas = ofertasResponseEntity.getBody();
        System.out.println(listaOfertas);
        return listaOfertas;

    }
    public List<OfertaDTO>getByCategorias(String categoria){
        ResponseEntity<List<OfertaDTO>> ofertasResponseEntity = restTemplate.exchange(GET_ALL_API, HttpMethod.GET, null, new ParameterizedTypeReference<List<OfertaDTO>>() {
        });
        List<OfertaDTO> listaOfertas = ofertasResponseEntity.getBody();
        System.out.println(listaOfertas);
        List<OfertaDTO> listacategoria= new ArrayList<>();
        if (listaOfertas.isEmpty()){
            return listaOfertas;
        }
        else {

            for(OfertaDTO oferta :listaOfertas) {

                if (oferta.getTipotrabajo()!=null){
                    if (oferta.getTipotrabajo().equals(categoria))
                        listacategoria.add(oferta);
                }

            }
        }
        if (listacategoria.isEmpty()){
            listacategoria=null;
        }
        System.out.println("LISTAR CATEGORIAS");
        System.out.println(listacategoria);
        return listacategoria;

    }
    public OfertaDTO getOfertById(String id){

        ResponseEntity<OfertaDTO> ofertasResponseEntity = restTemplate.exchange(GET_BY_OFERT_BY_ID_API+id, HttpMethod.GET, null, OfertaDTO.class);
        OfertaDTO Oferta = ofertasResponseEntity.getBody();
        System.out.println(ofertasResponseEntity);
        return Oferta;
    }
    public OfertaDTO updateOferta(String idoferta,OfertaRequest request){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<OfertaRequest> httpEntity = new HttpEntity<>(request,headers);
        ResponseEntity<OfertaDTO> ofertasResponseEntity = restTemplate.exchange(GET_ALL_API+idoferta, HttpMethod.PUT, httpEntity, OfertaDTO.class);
        OfertaDTO Oferta = ofertasResponseEntity.getBody();
        System.out.println(ofertasResponseEntity);
        return Oferta;

    }
    public DemandaDTO updateDemanda(String idoferta,DemandaRequest request){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<DemandaRequest> httpEntity = new HttpEntity<>(request,headers);
        ResponseEntity<DemandaDTO> demandaResponseEntity = restTemplate.exchange(API_DEMANDA_OFERTA+idoferta, HttpMethod.PUT, httpEntity, DemandaDTO.class);
        DemandaDTO demanda = demandaResponseEntity.getBody();
        System.out.println(demandaResponseEntity);
        return demanda;

    }
    public DemandaDTO saveDemanda(String idoferta,DemandaRequest request){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<DemandaRequest> httpEntity = new HttpEntity<>(request,headers);
        ResponseEntity<DemandaDTO> demandasResponseEntity = restTemplate.exchange(API_DEMANDA_OFERTA+idoferta, HttpMethod.POST, httpEntity, DemandaDTO.class);

        DemandaDTO demanda = demandasResponseEntity.getBody();
        System.out.println(demandasResponseEntity);
        return demanda;

    }
    public OfertaDTO save(OfertaRequest request){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<OfertaRequest> httpEntity = new HttpEntity<>(request,headers);
        ResponseEntity<OfertaDTO> ofertasResponseEntity = restTemplate.exchange(GET_ALL_API, HttpMethod.POST, httpEntity, OfertaDTO.class);

        OfertaDTO Oferta = ofertasResponseEntity.getBody();
        System.out.println(ofertasResponseEntity);
        return Oferta;

    }
    public DemandaDTO borrarDemanda(String idoferta,String username){
        ResponseEntity<DemandaDTO> ofertasResponseEntity = restTemplate.exchange(API_DEMANDA_OFERTA+idoferta+'/'+username, HttpMethod.DELETE, null, DemandaDTO.class);
        DemandaDTO demanda = ofertasResponseEntity.getBody();
        return demanda;
    }
    public OfertaDTO borrarOferta(String id){
        ResponseEntity<OfertaDTO> ofertasResponseEntity = restTemplate.exchange(GET_ALL_API+id, HttpMethod.DELETE, null, OfertaDTO.class);
        OfertaDTO Oferta = ofertasResponseEntity.getBody();
        return Oferta;
    }
    public Mensaje saveComentarioPuntos(String nameuser,ComentarioPuntosRequest request){

            User usuario=userRepository.findByUsername(nameuser).orElseThrow(() -> new RuntimeException("Error: no se obtuvo usuario en la DB."));


            System.out.println(usuario);
            Set<Mensaje> listaMensajes=usuario.getMensajestrabajosrealizados();

            //CREO UNA NUEVA SOLICITUD
        Mensaje mensajeNuevo=new Mensaje(request.getNombreUser(),
                    request.getPuntaje(),
                    request.getComentario(),
                    request.getFecha()
            );
            listaMensajes.add(mensajeNuevo);
            usuario.setMensajestrabajosrealizados(listaMensajes);
            usuario.setScore(Integer.toString(promedioPuntaje(listaMensajes,request.getPuntaje())));
            userRepository.save(usuario);


        return mensajeNuevo;
    }

    public List<Mensaje>getAllMensajes(String username){
        User usuario=userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("Error: no se obtuvo usuario en la DB."));
        if (usuario==null)
            return null;
        Set<Mensaje>mensajes=usuario.getMensajestrabajosrealizados();
        List<Mensaje> listMensajes = new ArrayList<>(mensajes);
        return listMensajes;

    }

    public Integer promedioPuntaje(Set<Mensaje>lista,String puntajeRequest){
        Integer puntajeTotal=0;
        Integer cantidad=0;
        for (Mensaje mensaje:lista){
            puntajeTotal=puntajeTotal+Integer.parseInt(mensaje.getPuntaje());
            cantidad=cantidad+1;
        }
        puntajeTotal=puntajeTotal+Integer.parseInt(puntajeRequest);
        cantidad=cantidad+1;
        Integer promedio=puntajeTotal/cantidad;
        return promedio;

    }


}
