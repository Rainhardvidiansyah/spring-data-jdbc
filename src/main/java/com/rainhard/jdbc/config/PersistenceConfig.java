package com.rainhard.jdbc.config;

import com.rainhard.jdbc.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.relational.core.mapping.event.BeforeSaveEvent;

import java.time.LocalDateTime;

@Configuration
public class PersistenceConfig {

    @Autowired
    private IdGenerator idgenerator;

    @Bean
    public ApplicationListener<BeforeSaveEvent> usersIdGenerator() {
        return event -> {
            var entity = event.getEntity();
            if (entity instanceof Users) {
                ((Users) entity).setId(idgenerator.generateId());
            }
        };
    }

    @Bean
    public ApplicationListener<BeforeSaveEvent> setusersCreatedAt() {
        return event -> {
            var entity = event.getEntity();
            if(entity instanceof Users){
                ((Users) entity).setCreatedAt(LocalDateTime.now());
            }
        };
    }

    @Bean
    public ApplicationListener<BeforeSaveEvent> setusersUpdatedAt() {
        return event -> {
            var entity = event.getEntity();
            if(entity instanceof Users){
                ((Users) entity).setUpdatedAt(LocalDateTime.now());
            }
        };
    }
}
