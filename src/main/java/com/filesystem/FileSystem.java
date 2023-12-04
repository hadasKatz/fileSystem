package com.filesystem;

import com.filesystem.db.DataBase;
import com.filesystem.entity.Dir;
import com.filesystem.entity.File;

public class FileSystem {
    public DataBase db = new DataBase();

    public void addDir(String parentDirName, String dirName){
        Dir dir = new Dir(dirName);
        db.addToDB(dirName, dir, parentDirName);
    }

    public void addFile(String parentDirName, String fileName, int fileSize){
        File file = new File(fileName, fileSize);
        db.addToDB(fileName, file, parentDirName);
    }

    public void delete(String entityName){
        db.deleteFromDB(entityName);
    }

    public void showFileSystem(){
        db.showSystemFile();
    }

    public static void main(String[] args) {
        FileSystem fileSystem = new FileSystem();
        fileSystem.addFile("parent_1", "file_1", 50);
        fileSystem.addFile("parent_1", "file_2", 30);
        fileSystem.addDir("parent_2", "dir_1");
        fileSystem.addFile("dir_1", "file_4", 80);
        fileSystem.addFile("parent_3", "file_5", 80);
        System.out.println("First Print:");
        fileSystem.showFileSystem();
        fileSystem.delete("file_2");
        fileSystem.delete("parent_3");
        System.out.println("After Deletion:");
        fileSystem.showFileSystem();
    }

}
