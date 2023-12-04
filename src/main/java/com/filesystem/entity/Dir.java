package com.filesystem.entity;

import com.filesystem.Printer;

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

    public Entity getChild(String childName){
        return this.children.get(childName);
    }

    public void printDir() {
        Printer.print(this.toString());
    }

    // The function gets all dir children, then set the formatting and returns the dir string including its children
    @Override
    public String toString() {
        String childrenList =  Printer.createPrintList(this.children.values());
        String toPrintChildrenList = Printer.setBrackets(childrenList, Printer.bracketsTypes.SQUARER);
        String stringDir = super.toString() + ", children:" + toPrintChildrenList;
        return "Dir: " + Printer.setBrackets(stringDir, Printer.bracketsTypes.CURLY);
    }
}