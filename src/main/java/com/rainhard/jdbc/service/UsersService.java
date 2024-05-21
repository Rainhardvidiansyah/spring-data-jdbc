package com.rainhard.jdbc.service;

import com.rainhard.jdbc.dto.UsersDto;
import com.rainhard.jdbc.entity.Users;
import com.rainhard.jdbc.repository.UsersRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsersService {

    private static final Logger log = LoggerFactory.getLogger(UsersService.class);
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UsersRepository usersRepository;

    public Users registration(UsersDto usersDto) {
        var user = convertToEntity(usersDto);
        log.info("User DTO Service class:{}", usersDto.toString());
        return this.usersRepository.save(user);
    }

    public List<Users> findAllUsers(){
        return this.usersRepository.findAllUsers();
    }

    private Users convertToEntity(UsersDto usersDto){
        Users users = modelMapper.map(usersDto, Users.class);
        return users;
    }

    private UsersDto convertToDataTransfer(Users users){
        if(users != null){
            return modelMapper.map(users, UsersDto.class);
        }else {
            throw new IllegalStateException();
        }
    }
}
