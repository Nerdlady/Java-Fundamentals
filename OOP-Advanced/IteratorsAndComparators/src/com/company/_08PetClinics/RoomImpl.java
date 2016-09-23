package com.company._08PetClinics;

public class RoomImpl implements Room {
    Pet pet;
    private int id;

    public RoomImpl(int id) {
        this.setId(id);
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

}
