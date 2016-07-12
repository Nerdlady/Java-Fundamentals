package com.company;

import com.company.interfaces.Mission;
import com.company.interfaces.Private;
import com.company.interfaces.Repair;
import com.company.interfaces.Soldier;
import com.company.models.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Soldier> soldiers = new LinkedList<>();
        Map<Integer,Private> privates = new LinkedHashMap<>();
        while (true) {
            String line = reader.readLine();
            if (line.equals("End")) {
                break;
            }

            String[] params = line.split("\\s+");
            int id = Integer.parseInt(params[1]);
            String firstName = params[2].trim();
            String lastName = params[3].trim();

            switch (params[0]) {
                case "Private":
                    double salary = Double.parseDouble(params[4]);
                    Private soldier = new PrivateImpl(id, firstName, lastName, salary);
                    soldiers.add(soldier);
                    privates.put(soldier.getId(),soldier);
                    break;
                case "LeutenantGeneral":
                    double generalSalary = Double.parseDouble(params[4]);
                    List<Private> generalsPrivates = new LinkedList<>();
                    for (int i = 5; i < params.length; i++) {
                        Private currentPrivate = privates.get(Integer.parseInt(params[i]));
                        generalsPrivates.add(currentPrivate);
                    }
                    Soldier leutenant = new LeutenantGeneralImpl(id, firstName, lastName, generalSalary, generalsPrivates);
                    soldiers.add(leutenant);
                    break;
                case "Engineer":
                    double engineerSalary = Double.parseDouble(params[4]);
                    String corps = params[5];
                    List<Repair> repairs= new LinkedList<>();

                    for (int i = 6; i < params.length ; i+=2) {
                        Repair repair = new RepairImpl(params[i],Integer.parseInt(params[i +1]));
                        repairs.add(repair);
                    }

                    try {
                        Soldier engineer = new EngineerImpl(id,firstName,lastName,engineerSalary,corps,repairs);
                        soldiers.add(engineer);
                    } catch (IllegalArgumentException ex){

                    }
                    break;
                case "Commando":
                    double commandoSalary = Double.parseDouble(params[4]);
                    String commandoCorps = params[5];
                    List<Mission> missions = new LinkedList<>();
                    for (int i = 6; i < params.length; i+=2) {
                        try {
                            Mission mission = new MissionImpl(params[i],params[i+1]);
                            missions.add(mission);
                        } catch (IllegalArgumentException ex){

                        }

                    }
                    try {
                        Soldier commando = new CommandoImpl(id,firstName,lastName,commandoSalary,commandoCorps,missions);
                        soldiers.add(commando);
                    } catch (IllegalArgumentException ex){

                    }
                  break;
                case "Spy":
                    int codeNumber = Integer.parseInt(params[4]);
                    Soldier spy = new SpyImpl(id,firstName,lastName,codeNumber);
                    soldiers.add(spy);
                    break;
            }
        }

        for (Soldier soldier : soldiers) {
            System.out.println(soldier.toString());
        }
    }
}
