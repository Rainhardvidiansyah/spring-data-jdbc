package com.rainhard.jdbc.dto;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsersDto {

    private static final Logger Log = LoggerFactory.getLogger(UsersDto.class);

    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
