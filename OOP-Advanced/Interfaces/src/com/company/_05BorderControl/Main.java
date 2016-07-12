package com.company._05BorderControl;

import com.company._05BorderControl.interfaces.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Identifiable> enters = new LinkedList<>();
        List<Birthable> birthables = new LinkedList<>();
        List<Buyer> buyers = new LinkedList<>();
        int lines = Integer.parseInt(reader.readLine());
        for (int i = 0; i < lines; i++) {
            String[] info = reader.readLine().split("\\s+");
            if (info.length ==4){
                String name = info[0];
                    int age = Integer.parseInt(info[1]);
                    String id = info[2];
                    String birthday = info[3];
                    Citizen citizen = new CitizenImpl(name,id,age,birthday);
                buyers.add(citizen);
            } else if(info.length ==3){
                String name = info[0];
                int age = Integer.parseInt(info[1]);
                String group = info[2];
                Rebel rebel = new RebelImpl(name,group,age);
                buyers.add(rebel);
            }
        }
        while (true){
            String line = reader.readLine();
            if (line.equals("End")){
                break;
            }

            for (Buyer buyer : buyers) {
                if (buyer.getName().equals(line)){
                    buyer.buyFoood();
                    break;
                }
            }
//            String[] info = line.split("\\s+");

//            switch (info[0]){
//                case "Citizen":
//                    String name = info[1];
//                    int age = Integer.parseInt(info[2]);
//                    String id = info[3];
//                    String birthday = info[4];
//                    Citizen citizen = new CitizenImpl(name,id,age,birthday);
//                    enters.add(citizen);
//                    birthables.add(citizen);
//                    break;
//                case "Robot":
//                    String model = info[1];
//                    String idR = info[2];
//                    Robot robot = new RobotImpl(model,idR);
//                    enters.add(robot);
//                    break;
//                case "Pet":
//                    String petName = info[1];
//                    String petBirthday = info[2];
//                    Pet pet = new PetImpl(petName,petBirthday);
//                    birthables.add(pet);
//
//            }

        }

        String invelid = reader.readLine();

        System.out.println(buyers.stream().mapToInt(Buyer::getFood).sum());
    }
}
