package com.javaweb.securityjwtauthmongodb.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class JwtResponse {
    @Getter @Setter
    private String token;
    @Getter @Setter
    private String type = "Bearer";
    @Getter @Setter
    private String id;
    @Getter @Setter
    private String username;
    @Getter @Setter
    private String email;
    @Getter @Setter
    private List<String> roles;

    public JwtResponse(String accessToken, String id, String username, String email, List<String> roles) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }
}
