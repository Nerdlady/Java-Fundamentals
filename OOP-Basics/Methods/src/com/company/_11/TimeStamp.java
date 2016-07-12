package com.company._11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class TimeStamp {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TimeSpanList timeSpanList = new TimeSpanList();

        while (true){
            String line = reader.readLine();
            if (line.equals("End")){
                break;
            }

            String[] info = line.split("\\s+");
            switch (info[0]){
                case "Add":
                    timeSpanList.add(info[1]);
                    break;
                case "Set":
                    timeSpanList.set(Integer.parseInt(info[1]),info[2]);
                    break;
            }
        }

        timeSpanList.printInfo();
    }
}

class TimeSpanList{
    List<String> names;
    List<Date> dates;

    public TimeSpanList() {
        this.names = new LinkedList<>();
        dates = new LinkedList<>();
        Date date = new Date();
        System.out.println("Initial time -> " + date.toString());
    }

    public void add(String name){
        names.add(name);
        Date date = new Date();
        dates.add(date);
    }

    public void set(int index,String name){
        names.set(index,name);
        Date date = new Date();
        dates.set(index,date);
    }

    public void printInfo(){
        for (int i = 0; i < names.size() ; i++) {
            System.out.printf("Index %d: (%s) -> %s%n",i,names.get(i),dates.get(i));
        }
    }
}
