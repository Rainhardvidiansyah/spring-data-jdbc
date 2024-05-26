package com.rainhard.jdbc.repository;

import com.rainhard.jdbc.entity.Users;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends CrudRepository<Users, Long> {

    @Query("SELECT * FROM users")
    List<Users> findAllUsers();

    @Query("SELECT email FROM users WHERE email = :email")
    Optional<Users> findByEmail(@Param("email") String email);

    @Query("SELECT * FROM users WHERE id = :id")
    Optional<Users> findById(@Param("id") Long id);


    @Modifying
    @Query("UPDATE users SET username = :username WHERE id = :id")
    int updateUser(@Param("id") Long id, @Param("username") String username);
}
