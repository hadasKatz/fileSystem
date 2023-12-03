package com.filesystem.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This parent class of Dir and File, contains the common fields and logic
 **/
public class Entity {
    private final String name;
    private final LocalDateTime creationTime;

    public Entity(String name) {
        this.name = name;
        this.creationTime = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }

    public String getCreationTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return creationTime.format(formatter);
    }

    @Override
    public String toString() {
        return "name: " + name + ", creation time: " + getCreationTime();
    }
}
