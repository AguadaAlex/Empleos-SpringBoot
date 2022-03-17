package com.javaweb.employservice.repository;

import com.javaweb.employservice.entity.OfferWork;
import com.javaweb.employservice.entity.Work;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WorkRepository extends MongoRepository<Work, String> {
   // Optional<Work> findById(String id);

    Optional<Work> findByNombre(String nombre);

    //Boolean existsByWorkname(String workname);
}
