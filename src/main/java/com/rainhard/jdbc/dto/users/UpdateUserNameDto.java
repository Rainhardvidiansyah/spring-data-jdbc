package com.rainhard.jdbc.dto.users;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateUserNameDto {

    @JsonProperty("username")
    private String userName;


    public UpdateUserNameDto(){}

    public UpdateUserNameDto(String userName){
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
