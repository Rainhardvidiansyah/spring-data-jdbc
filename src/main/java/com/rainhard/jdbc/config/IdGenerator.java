package com.rainhard.jdbc.config;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Component
public class IdGenerator {

    public final AtomicLong atomicLong = new AtomicLong();

    public Long generateId(){
        return atomicLong.incrementAndGet();
    }
}
