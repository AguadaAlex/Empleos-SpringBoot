package com.javaweb.employservice.repository;
import com.javaweb.employservice.entity.OfferWork;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface OffertWorkRepository extends MongoRepository<OfferWork, String>{
    Boolean existsByUsername(String username);
    OfferWork findByTitulo(String id);
    Optional<OfferWork> findById(String id);

    List<OfferWork> findByUsername(String name);
}
