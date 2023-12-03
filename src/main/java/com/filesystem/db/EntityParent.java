package com.filesystem.db;

import java.util.HashMap;

/**
    * This class was created to allow fast delete in case of file or child dir deletion
    * The class contains a Map mapping between the child entity to it's parent
    * Therefor when given a file name to the delete function, no search is needed
 **/
public class EntityParent {
    private final HashMap<String, String> table;

    public EntityParent() {
        this.table = new HashMap<>();
    }

    public String getParent(String name){
        return this.table.get(name);
    }

    public void addDir(String name, String parentName){
        this.table.put(name, parentName);
    }
}
