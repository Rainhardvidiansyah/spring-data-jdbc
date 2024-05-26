package com.rainhard.jdbc.service;

import com.rainhard.jdbc.entity.Users;
import com.rainhard.jdbc.repository.UsersRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class UsersService {

    private static final Logger log = LoggerFactory.getLogger(UsersService.class);
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UserRolesService userRolesService;

    @Transactional
    public Users registration(Users users) {
        return usersRepository.save(users);
    }

    public List<Users> findAllUsers(){
        return this.usersRepository.findAllUsers();
    }

    public boolean checkUserEmail(String email){
        var user = this.usersRepository.findByEmail(email);
        return user.isPresent();
    }

    public boolean checkUserId(Long id){
        var user = this.usersRepository.findById(id);
        return user.isPresent();
    }

    public void setRoles(Long userId){
        userRolesService.addUserRole(userId);
    }

    public int updateUser(Long id, String username){
        return this.usersRepository.updateUser(id, username);
    }

}
