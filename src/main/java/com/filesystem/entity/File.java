package com.filesystem.entity;

public class File extends Entity{
    private final int size;

    public File(String name, int size) {
        super(name);
        this.size = size;
    }

    @Override
    public String toString() {
        return "File: {" + super.toString() + ", size: " + size + "}";
    }
}