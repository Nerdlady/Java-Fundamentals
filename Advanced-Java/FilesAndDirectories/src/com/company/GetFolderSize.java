package com.company;


import java.io.*;

public class GetFolderSize {
    public static void main(String[] args) {

        String path = "BashSoft";
        long size = 0;

        try{
            File current = new File(path);
            File[] files =current.listFiles();
            for (File file : files) {
                if (!file.isDirectory()){
                   size += file.length();
                }
            }
            System.out.println(size);

        } catch (Exception e) {
        }

    }
}
