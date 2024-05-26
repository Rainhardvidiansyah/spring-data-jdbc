package com.rainhard.jdbc.controller;

import com.rainhard.jdbc.dto.UsersDto;
import com.rainhard.jdbc.dto.users.UpdateUserNameDto;
import com.rainhard.jdbc.entity.Users;
import com.rainhard.jdbc.service.RolesService;
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

    //Branch Check-find-all-functionality
    @Autowired
    private RolesService rolesService;


    @PostMapping("/")
    public ResponseEntity<?> registration(@RequestBody UsersDto usersDto){
        var isEmailFound = this.usersService.checkUserEmail(usersDto.getEmail());
        log.info("isEmailFound:" + isEmailFound);

        if(isEmailFound){
            return ResponseEntity.badRequest().body("Email telah terdaftar");
        }
        log.info("User Email Dto in Users Controller: " + usersDto.getEmail());

        if(usersDto.getPassword().isEmpty()){
            return new ResponseEntity<>(errorResponse("Kata sandi harus diisi!!!"), HttpStatus.BAD_REQUEST);
        }

        var users = modelMapper.map(usersDto, Users.class);


        var savedUsers = usersService.registration(users);

        if(users.getId() != null) {
            usersService.setRoles(savedUsers.getId());
        }else{
            return new ResponseEntity<>(errorResponse("Gagal menetapkan role!"), HttpStatus.BAD_REQUEST);
        }

        log.info("User id from registration method in controller:{}", users.getId());
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

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUserName(@PathVariable Long id, @RequestBody UpdateUserNameDto nameDto){
        var userId = this.usersService.checkUserId(id);
        if(!userId){
            return new ResponseEntity<>(errorResponse("User id tidak ditemukan"), HttpStatus.BAD_REQUEST);
        }
        this.usersService.updateUser(id, nameDto.getUserName());

        return new ResponseEntity<>(successResponse("Nama pengguna telah diperbarui!"), HttpStatus.OK);
    }

    private <T> T successResponse(T t){
        return t;
    }

    private String errorResponse(String response){
        return response;
    }

}
