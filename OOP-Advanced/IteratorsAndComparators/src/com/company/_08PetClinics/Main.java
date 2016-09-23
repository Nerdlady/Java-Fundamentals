package com.company._08PetClinics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Clinic> clinics = new HashMap<>();
        HashMap<String, Pet> pets = new HashMap<>();
        int numberOfLines = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numberOfLines; i++) {
            String[] info = reader.readLine().split("\\s+");
            switch (info[0]) {
                case "Create":
                    switch (info[1]) {
                        case "Pet":
                            String name = info[2];
                            if (pets.containsKey(name)) {

                                continue;
                            }

                            pets.put(name, new PetImpl(name, Integer.parseInt(info[3]), info[4]));

                            break;
                        case "Clinic":
                            String clinicName = info[2];
                            int numberOfRooms = Integer.parseInt(info[3]);
                            if (clinics.containsKey(clinicName)) {

                                continue;
                            }

                            try {
                                Clinic clinic = new ClinicImpl(clinicName, numberOfRooms);
                                clinics.put(clinicName, clinic);

                            } catch (IllegalArgumentException e) {
                                System.out.println("Invalid Operation!");
                            }
                    }
                    break;
                case "Add":
                    try {
                        Pet pet = pets.get(info[1]);
                        Clinic clinic = clinics.get(info[2]);
                        if (clinic.addPet(pet)) {
                            clinics.put(clinic.getName(), clinic);
                            System.out.println(true);
                        } else {
                            System.out.println(false);
                        }
                    } catch (NullPointerException e) {
                        System.out.println("Invalid Operation!");
                    }
                    break;
                case "Release":
                    try {
                        Clinic clinic1 = clinics.get(info[1]);
                        System.out.println( clinic1.release());
                        clinics.put(clinic1.getName(), clinic1);
                    } catch (NullPointerException e) {
                        System.out.println("Invalid Operation!");
                    }
                    break;
                case "Print":
                    Clinic clinic2 = clinics.get(info[1]);
                    if (info.length > 2) {
                        Pet pet1 = clinic2.getPetFromRoom(Integer.parseInt(info[2]) -1);
                        if (pet1 != null){
                            System.out.println(pet1.toString());
                        }
                        else {
                            System.out.println("Room empty");
                        }
                    } else {
                        Room[] rooms = clinic2.getRooms();
                        for (Room room : rooms) {
                            if (room.getPet() != null){
                                System.out.println(room.getPet().toString());
                            }
                            else {
                                System.out.println("Room empty");
                            }

                        }
                    }
                    break;
                case "HasEmptyRooms":
                    System.out.println(clinics.get(info[1]).hasEmptyRooms());
                    break;
                default:

                    System.out.println("Invalid Operation!");

            }
        }
    }
}
