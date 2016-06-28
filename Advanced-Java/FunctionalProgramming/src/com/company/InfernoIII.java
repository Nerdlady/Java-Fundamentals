package com.company;


import java.util.*;
import java.util.function.Predicate;

public class InfernoIII {
    public  static List<Integer> gems= new LinkedList<>();
    public static HashMap<Integer,ArrayList<Integer>> toRemove = new HashMap<>();
    public static int steps =0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] gemsStr = scanner.nextLine().split("\\s+");

        for (String s : gemsStr) {
            gems.add(Integer.parseInt(s));
        }
        toRemove.put(steps,new ArrayList<>());
         while (true){
             String command = scanner.nextLine();
             if (command.equals("Forge")){
                 toRemove.remove(steps);
                 break;
             }


             String[] commands = command.split(";");

             switch (commands[0]){
                 case "Exclude":
                     boolean did = false;
                     switch (commands[1]){
                         case "Sum Left":
                             did = execude(x -> (x - 1 < 0 ? 0 : gems.get(x - 1)) + gems.get(x) == Integer.parseInt(commands[2]));
                             break;
                         case "Sum Right":
                             did = execude(x -> gems.get(x ) + (x + 1 >= gems.get(x ) ? 0 : gems.get(x + 1)) == Integer.parseInt(commands[2]));
                             break;
                         case "Sum Left Right":
                             did =  execude(x -> (x - 1 < 0 ? 0 : gems.get(x  - 1)) + gems.get(x) + (x + 1 >=gems.size() ? 0 : gems.get(x + 1)) == Integer.parseInt(commands[2]));
                             break;

                     }
                     if (did){
                         steps++;
                         toRemove.put(steps,new ArrayList<>());
                     }

                     break;
                 case "Reverse":
                     toRemove.remove(steps);
                        toRemove.remove(steps-1);
                     steps --;
                     break;
             }


         }

        remove();

        for (Integer gem : gems) {
            System.out.printf("%d ", gem);
        }
    }

    private static boolean execude(Predicate<Integer> predicate){
        boolean did = false;
        List<Integer> execuded = new LinkedList<>();
        for (int i = 0; i < gems.size(); i++) {
            if (predicate.test(i)){
                execuded.add(i);
                did = true;
            }
        }
       toRemove.get(steps).addAll(execuded);
        return did;
    }

    private static void remove(){
        ArrayList<Integer> indexes = getIndexes();
        ArrayList<Integer> finall = new ArrayList<>();
        for (int i = 0; i < gems.size(); i++) {

                if (!indexes.contains(i)){
                    finall.add(gems.get(i));
                }

        }
        gems = finall;
    }

    private static  ArrayList<Integer> getIndexes(){
        ArrayList<Integer> ints = new ArrayList<>();
        if (toRemove.size() == 0){
            ints.add(-1);
            return ints;
        }
        for (int i = 0; i < toRemove.size(); i++) {
            if (toRemove.get(i).size() == 0){
                ints.add(-1);
                continue;
            }
            for (int integer : toRemove.get(i)) {
                ints.add(integer);
            }
        }
        return ints;
    }
}
