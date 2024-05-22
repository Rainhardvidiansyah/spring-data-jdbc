package com.rainhard.jdbc.repository;

import com.rainhard.jdbc.entity.Roles;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolesRepository extends CrudRepository<Roles, Long> {

    @Query("SELECT * FROM roles")
    List<Roles> getRoles();

}
