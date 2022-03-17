package com.javaweb.securityjwtauthmongodb.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "roles")
public class Role {
    @Getter @Setter
    @Id
    private String id;
    @Getter @Setter
    private ERole name;

    public Role() {

    }
}
