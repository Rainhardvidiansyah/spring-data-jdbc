package com.rainhard.jdbc.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("user_roles")
public class UserRoles {

    @Column("user_id")
    private Long userId;

    @Column("role_id")
    private Long roleId;

    @CreatedDate
    @Column("createdAt")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column("updatedAt")
    private LocalDateTime updatedAt;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
