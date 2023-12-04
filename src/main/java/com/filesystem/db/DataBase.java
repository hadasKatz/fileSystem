package com.filesystem.db;

import com.filesystem.FileSystem;
import com.filesystem.entity.Dir;
import com.filesystem.entity.Entity;
import com.filesystem.entity.File;

public class DataBase {
    private final DirsTable dirsTable;
    private final EntityParent entityParent;

    public DataBase() {
        this.entityParent = new EntityParent();
        this.dirsTable = new DirsTable();
    }

    public void addToDB(String name, Entity entity, String parentName){
        String grandParent = this.entityParent.getParent(parentName);
        // The parent dir is not a child of other dir- add to table
        if (grandParent == null){
            // Adds to the dirs table
            this.dirsTable.addParentDir(parentName, entity);
        }
        else{
            this.dirsTable.addToGrandParentDir(grandParent, entity, parentName);
        }
        // Adds to opposite mapping: child to parent
        this.entityParent.addDir(name, parentName);
    }

    public void deleteFromDB(String name){
        // If the dir is a parent dir- delete from dirs table: delete dir and all children related
        if (dirsTable.isDirExist(name)) {
            this.dirsTable.deleteDir(name);
            return;
        }
        // If the dir is not a parent dir- use entityParent, find the parent name, and delete child from parent
        String parentName = this.entityParent.getParent(name);
        Dir parentDir = this.dirsTable.getDir(parentName);
        parentDir.deleteChild(name);
    }

    public DirsTable getDirsTable(){
        return this.dirsTable;
    }
    public void showSystemFile(){
        this.dirsTable.printTable();
    }

}
