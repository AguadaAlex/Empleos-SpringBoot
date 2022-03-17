package com.javaweb.securityjwtauthmongodb.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

@Document(collection = "users")
public class User {
@Getter @Setter
    @Id
    private String id;
    @Getter @Setter
    @NotBlank
    @Size(max = 20)
    private String username;
    @Getter @Setter
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    @Getter @Setter
    @NotBlank
    @Size(max = 120)
    private String password;
    @Getter @Setter
    @DBRef
    private Set<Role> roles = new HashSet<>();
    @Getter @Setter
    @NotBlank
    @Size(max = 10)
    private String score;
    @Getter @Setter
    private Set<Mensaje> mensajestrabajosrealizados = new HashSet<>();

    public User() {
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}