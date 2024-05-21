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
}


