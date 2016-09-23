package com.company._08PetClinics;

import java.util.Iterator;

public class ClinicImpl implements Clinic, Iterable<Pet> {
    private Room[] rooms;
    private String name;
    private int numberOfFullRooms;
    private int center;
    private boolean removed;

    public ClinicImpl(String name, int numberOfRooms) {
        this.setName(name);
        this.setRooms(numberOfRooms);
        this.center = numberOfRooms / 2;
        this.removed = false;
    }

    public void setRooms(int numberOfRooms) {
        if (numberOfRooms % 2 == 0) {
            throw new IllegalArgumentException("Number of rooms must be odd number");
        }
        this.rooms = new Room[numberOfRooms];
        for (int i = 0; i < numberOfRooms; i++) {
            this.rooms[i] = new RoomImpl(i);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean hasEmptyRooms() {
        return this.numberOfFullRooms == this.rooms.length - 1;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean addPet(Pet pet) {
        int index = this.getNextFreeRoom();
        if (index != -1) {
            this.rooms[index].setPet(pet);
            this.numberOfFullRooms++;
            return true;

        }
        return false;

    }

    @Override
    public boolean release() {
        this.iterator().remove();
        return removed;
    }

    @Override
    public Pet getPetFromRoom(int roomNumber) {
        return this.rooms[roomNumber].getPet();
    }

    @Override
    public Room[] getRooms() {
        return this.rooms;
    }


    private boolean checkForFreeRoom(int index) {
        if (this.rooms[index].getPet() == null && index <= this.rooms.length && index >= 0) {
            return true;
        }
        return false;
    }

    @Override
    public Iterator<Pet> iterator() {
        return new ClinicIterator();
    }

    private int getNextFreeRoom() {
        int index = center;
        int number = 0;
        while (true) {
            int nextIndex = index - number;
            int nextRightIndex = index + number;
            if (nextIndex < 0 && nextRightIndex >= rooms.length - 1) {
                break;
            }
            if (nextIndex >= 0 && checkForFreeRoom(nextIndex)) {
                index = index - number;
                return index;
            }

            if (nextRightIndex < rooms.length && checkForFreeRoom(nextRightIndex)) {
                index = index + number;
                return index;
            }
            number++;
        }
        return -1;
    }

    private class ClinicIterator implements Iterator<Pet> {
        int index = 0;

        @Override
        public boolean hasNext() {
            return index < rooms.length;
        }

        @Override
        public Pet next() {
            return rooms[index++].getPet();
        }

        @Override
        public void remove() {
            int number = 0;
            int nextRightIndex = center + number;
            while (true) {
                if (nextRightIndex >= rooms.length - 1) {
                    nextRightIndex = 0;
                }

                if (!checkForFreeRoom(nextRightIndex)) {
                    rooms[nextRightIndex].setPet(null);
                    numberOfFullRooms--;
                    removed = true;
                    break;
                }

                nextRightIndex++;

                if (nextRightIndex == center || center == 0) {
                    removed = false;
                    break;
                }

            }


        }
    }
}

