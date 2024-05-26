package com.rainhard.jdbc.dto.response;

public class UserRolesResponse {

    private String email;
    private String role_name;

    public UserRolesResponse(String email, String role_name) {
        this.email = email;
        this.role_name = role_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
}
