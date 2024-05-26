package com.rainhard.jdbc.controller;

import com.rainhard.jdbc.dto.response.UserRolesResponse;
import com.rainhard.jdbc.service.UserRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user-roles")
public class UserRolesController {

    @Autowired
    private UserRolesService userRolesService;


    @GetMapping("")
    public ResponseEntity<?> getAllUsersRoles(){
        List<UserRolesResponse> result = this.userRolesService.getRoles();

        if(result.isEmpty()){
            return new ResponseEntity<>(response("Data tidak ada"), HttpStatus.valueOf(404));
        }
        return new ResponseEntity<>(response(result), HttpStatus.OK);
    }


    private <T> T response(T t){
        return t;
    }
}
