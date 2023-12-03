package com.filesystem;

import com.filesystem.entity.Dir;
import org.junit.Test;
import java.util.HashMap;
import static org.junit.Assert.assertTrue;

public class FileSystemTests {
    FileSystem fileSystem = new FileSystem();
    @Test
    public void testSFileSystem(){
        fileSystem.addFile("parent_1", "file_1", 50);
        fileSystem.addFile("parent_1", "file_2", 30);
        fileSystem.addDir("parent_2", "dir_1");
        HashMap<String, Dir> dirsTable = fileSystem.db.getDirsTable().getTable();
        assertTrue(dirsTable.containsKey("parent_1"));
        assertTrue(dirsTable.containsKey("parent_2"));
    }
}