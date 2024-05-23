package com.rainhard.jdbc.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Table("roles")
public class Roles {

    @Id
    private Long id;

    @Column("role_name")

    private String roleName;

    @CreatedDate
    @Column("createdAt")
    private LocalDate createdAt;

    @LastModifiedDate
    @Column("updatedAt")
    private LocalDateTime updatedAt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Long getRoleId() {
        return  this.id;
    }
}


