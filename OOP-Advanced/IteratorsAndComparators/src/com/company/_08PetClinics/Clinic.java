package com.company._08PetClinics;

public interface Clinic extends Iterable<Pet> {
    boolean addPet(Pet pet);
    boolean release();
    Pet getPetFromRoom(int roomNumber);
    Room[] getRooms();
    String getName();

    boolean hasEmptyRooms();
}
