package com.rainhard.jdbc.service;

import com.rainhard.jdbc.dto.response.UserRolesResponse;
import com.rainhard.jdbc.entity.Roles;
import com.rainhard.jdbc.entity.UserRoles;
import com.rainhard.jdbc.repository.RolesRepository;
import com.rainhard.jdbc.repository.UserRolesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRolesService {

    private static final Logger log = LoggerFactory.getLogger(UserRolesService.class);

    @Autowired
    private UserRolesRepository userRolesRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private RolesRepository rolesRepository;

    public void addUserRole(Long user_id) {
        if(user_id == null){
            return;
        }
        List<Roles> roles = this.rolesRepository.getRoles();
        Long roleId = null;
        for (Roles role : roles) {
            if("ROLE_USER".equals(role.getRoleName())){
                roleId = role.getRoleId();
                break;
            }
        }
        log.info("User Roles Services::>> value of user id within block if:{}", user_id);
        if(roleId != null){
            String sql = "INSERT INTO user_roles (user_id, role_id) VALUES (?,?)";
            jdbcTemplate.update(sql, user_id, roleId);
        }
    }

    public List<UserRoles> getAllUserRoles(){
        return this.userRolesRepository.findAllUsersRole();
    }

    public List<UserRolesResponse> getRoles(){
        return this.userRolesRepository.getUsersAndEmail();
    }

}
