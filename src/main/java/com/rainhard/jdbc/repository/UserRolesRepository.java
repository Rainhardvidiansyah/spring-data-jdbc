package com.rainhard.jdbc.repository;


import com.rainhard.jdbc.dto.response.UserRolesResponse;
import com.rainhard.jdbc.entity.UserRoles;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRolesRepository extends CrudRepository<UserRoles, Long> {

    @Query("SELECT * FROM user_roles")
    List<UserRoles> findAllUsersRole();

    @Query("SELECT u.email, r.role_name " +
            "FROM user_roles ur " +
            "JOIN users u ON ur.user_id = u.id " +
            "JOIN roles r ON ur.role_id = r.id")
    List<UserRolesResponse> getUsersAndEmail();
}
