package com.filesystem.db;

import com.filesystem.entity.Dir;
import com.filesystem.entity.Entity;
import java.util.HashMap;

/**
 * This class contains the Dirs table and it's functionality
 **/
public class DirsTable implements Table{
    private final HashMap<String, Dir> table;

    public DirsTable() {
        this.table = new HashMap<>();
    }

    public HashMap<String, Dir> getTable(){
        return this.table;
    }

    public void printTable() {
        for (Dir dir: table.values()) {
            dir.printDir();
        }
    }

    public Dir getDir(String name){
        if (!isDirExist(name)){
            addDir(name, new Dir(name));
        }
        return this.table.get(name);
    }

    public boolean isDirExist(String name){
        return this.table.containsKey(name);
    }

    public void addDir(String name, Dir dir){
        this.table.put(name, dir);
    }

    // When adding a new dir/file, this function creates an Entity for the parent (if not existed) and add it to the table
    // With the original dir/file as the parent child
    public void addParentDir(String parentName, Entity entity){
        Dir parentDir = this.getDir(parentName);
        parentDir.addChild(entity);
    }

    public void deleteDir(String name){
        if (isDirExist(name)) {
            this.table.remove(name);
        }
    }
}
