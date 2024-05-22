package com.rainhard.jdbc.service;

import com.rainhard.jdbc.entity.Roles;
import com.rainhard.jdbc.repository.RolesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolesService {

    private static final Logger log = LoggerFactory.getLogger(RolesService.class);

    @Autowired
    private RolesRepository rolesRepository;

    public List<Roles> findAllRoles() {
        return this.rolesRepository.getRoles();
    }

    public Roles getRolesById(Long id){
        Optional<Roles> roles = this.rolesRepository.findById(id);
        return roles.get();
    }
}