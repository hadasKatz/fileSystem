package com.filesystem;

import com.filesystem.entity.Dir;
import com.filesystem.entity.File;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class DirTests {
    @Test
    public void createDirTest(){
        Dir dir = new Dir("MyDir");
        String dirString = dir.toString();
        assertTrue(dirString.startsWith("Dir"));
        assertTrue(dirString.contains("name: MyDir"));
        assertTrue(dirString.contains("children:[]"));
    }

    @Test
    public void addChildTest(){
        Dir dir = new Dir("MyDir");
        File file = new File("MyFile", 50);
        dir.addChild(file);
        String dirString = dir.toString();
        assertTrue(dirString.startsWith("Dir"));
        assertTrue(dirString.contains("name: MyDir"));
        assertTrue(dirString.contains("children"));
        assertTrue(dirString.contains("File"));
        assertTrue(dirString.contains("name: MyFile"));
        assertTrue(dirString.contains("size: 50"));
    }

    @Test
    public void deleteChildTest(){
        Dir dir = new Dir("MyDir");
        File file = new File("MyFile", 50);
        dir.addChild(file);
        String dirString = dir.toString();
        assertTrue(dirString.contains("File"));
        assertTrue(dirString.contains("name: MyFile"));
        assertTrue(dirString.contains("size: 50"));
        dir.deleteChild("MyFile");
        dirString = dir.toString();
        assertTrue(dirString.contains("children:[]"));

    }
}