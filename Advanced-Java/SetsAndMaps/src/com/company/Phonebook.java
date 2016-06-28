package com.company;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String ,String> data = new HashMap<>();
       // try {
            while (true){
                String line = scanner.nextLine();
                if (line.toLowerCase().equals("search")){
                    break;
                }
                if(line.isEmpty() || line.equals("") || line.equals(null)){
                    continue;
                }

                String[] info = line.split("-");
                if (info.length <2){
                    continue;
                }
                if (!data.containsKey(info[0])){
                    data.put(info[0],"");
                }

                data.put(info[0],info[1]);
            }

            while (true){
                String tosearch = scanner.nextLine();
                if (tosearch.equals("stop") ){
                    break;
                }
                if(tosearch.isEmpty() || tosearch.equals("") || tosearch.equals(null)){
                    continue;
                }
                if (data.containsKey(tosearch)){
                    System.out.printf("%s -> %s%n",tosearch,data.get(tosearch));
                } else {
                    System.out.printf("Contact %s does not exist.%n",tosearch);
                }
            }
//        } catch (Exception e){
//
//        }

    }
}
