package com.rainhard.jdbc.repository;

import com.rainhard.jdbc.entity.Users;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends CrudRepository<Users, Long> {

    @Query("SELECT * FROM users")
    List<Users> findAllUsers();


    @Query("SELECT email FROM users WHERE email = :email")
    Optional<Users> findByEmail(@Param("email") String email);
}
