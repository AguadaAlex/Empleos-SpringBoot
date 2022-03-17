package com.javaweb.securityjwtauthmongodb.repository;

import com.javaweb.securityjwtauthmongodb.entity.ERole;
import com.javaweb.securityjwtauthmongodb.entity.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}
