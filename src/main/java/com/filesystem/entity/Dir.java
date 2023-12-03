package com.filesystem.entity;

import java.util.ArrayList;
import java.util.HashMap;

public class Dir extends Entity{
    private final HashMap<String, Entity> children;

    public Dir(String name) {
        super(name);
        this.children = new HashMap<>();
    }

    public void addChild(Entity entity){
        children.put(entity.getName(), entity);
    }

    public void deleteChild(String name){
        this.children.remove(name);
    }

    public void printDir() {
        System.out.println(this);
    }

    // The function gets all dir children, then set the formatting and returns the dir string including its children
    @Override
    public String toString() {
        ArrayList<String> childList = new ArrayList<>();
        for (Entity children: this.children.values()) {
            childList.add(children.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (childList.size() > 0){
            stringBuilder.append(childList.get(0));
            for (int i = 1 ; i < childList.size(); i++){
                stringBuilder.append(", ").append(childList.get(i));
            }
        }
        return "Dir: {" + super.toString() + ", children:[" + stringBuilder + "]}";
    }
}