package com.company._06MirrorImage.creators;

public class IdCreator {
    private static int id = 0;
    public static int nextId(){
        return id++;
    }
}
