package com.rainhard.jdbc.controller;

import com.rainhard.jdbc.dto.UsersDto;
import com.rainhard.jdbc.entity.Users;
import com.rainhard.jdbc.service.UsersService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/api/v1/users")
public class UsersController {

    private static final Logger log = LoggerFactory.getLogger(UsersController.class);

    @Autowired
    private UsersService usersService;

    @Autowired
    private ModelMapper modelMapper;

    public String getUsersData(){
        return "Users Data";
    }

    @PostMapping("/")
    public ResponseEntity<?> registration(@RequestBody UsersDto usersDto){
        log.info("User Email Dto in Users Controller: " + usersDto.getEmail());
        if(usersDto.getPassword().isEmpty()){
            return new ResponseEntity<>(errorResponse("Kata sandi harus diisi!!!"), HttpStatus.BAD_REQUEST);
        }
        var users = this.usersService.registration(usersDto);
        return new ResponseEntity<>(successResponse(users), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<?> findAllUsers(){
        List<Users> users = this.usersService.findAllUsers();
        List<String> userEmail = new ArrayList<>();
        for(Users u : users){
            userEmail.add(u.getEmail());
        }
        System.out.println(userEmail);

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    private String successResponse(Users users){
        return users.getEmail() + " berhasil terdaftar";
    }

    private String errorResponse(String response){
        return response;
    }

    //TODO: will use this generic method later
    private <T> T err(T t){
        return t;
    }


}
