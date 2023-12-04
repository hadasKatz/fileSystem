package com.filesystem;

import com.filesystem.entity.Entity;

import java.util.ArrayList;
import java.util.Collection;

public class Printer {
    public enum bracketsTypes {
        SQUARER,
        CURLY,
        ROUND
    }

    public static void print(String input){
        System.out.println(input);
    }

    public static String setBrackets(String input, bracketsTypes bracketsTypes){
        if (bracketsTypes == Printer.bracketsTypes.ROUND){
            return "(" + input + ")";
        }
        if (bracketsTypes == Printer.bracketsTypes.SQUARER){
            return "[" + input + "]";
        }
        if (bracketsTypes == Printer.bracketsTypes.CURLY){
            return "{" + input + "}";
        }
        return input;
    }

    public static String createPrintList(Collection<Entity> values){
        if (values.size() == 0){
            return "";
        }
        // Convert all items to string
        ArrayList<String> entitiesList = new ArrayList<>();
        for (Entity entity: values) {
            entitiesList.add(entity.toString());
        }
        // Add commas
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(entitiesList.get(0));
        for (int i = 1 ; i < entitiesList.size(); i++){
            stringBuilder.append(", ").append(entitiesList.get(i));
        }
        return stringBuilder.toString();
    }
}
