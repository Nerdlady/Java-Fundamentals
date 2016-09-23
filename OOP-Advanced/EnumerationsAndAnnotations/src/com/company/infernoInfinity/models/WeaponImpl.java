package com.company.infernoInfinity.models;

import com.company.infernoInfinity.enums.Stat;
import com.company.infernoInfinity.enums.WeaponType;
import com.company.infernoInfinity.interfaces.Weapon;

import java.util.Arrays;
import java.util.List;

public class WeaponImpl implements Weapon {
    private String name;
    private  int minDamage;
    private int maxDamage;
    private Stat[] stats;

    public WeaponImpl(String name, WeaponType weaponType) {
       this.setName(name);
        this.setMinDamage(weaponType.getMinDamage());
        this.setMaxDamage(weaponType.getMaxDamage());
        this.stats = new Stat[weaponType.getNumberOfStats()];
    }

    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    public void setMinDamage(int minDamage) {
        this.minDamage = minDamage;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getMinDamage() {
        return this.minDamage;
    }

    @Override
    public int getMaxDamage() {
        return this.maxDamage;
    }

    @Override
    public List<Stat> getStats() {
        return Arrays.asList(this.stats);
    }

    @Override
    public void addStatAtIndex(Stat stat, int index) {
        if (index < 0 || index >= this.stats.length){
            throw new IndexOutOfBoundsException();
        }

        if (this.stats[index] != null){
            this.removeAtIndex(index);
        }

        this.stats[index] = stat;
        for (int i = 0; i < stat.getStrength(); i++) {
            this.minDamage += 2;
            this.maxDamage += 3;
        }

        for (int i = 0; i < stat.getAgility(); i++) {
            this.minDamage += 1;
            this.maxDamage +=4;
        }
    }

    @Override
    public void removeAtIndex(int index) {
        if (index < 0 || index >= this.stats.length){
            throw new IndexOutOfBoundsException();
        }

        if (this.stats[index] != null){
            Stat stat = this.stats[index];
            for (int i = 0; i < stat.getStrength(); i++) {
                this.minDamage -= 2;
                this.maxDamage -= 3;
            }

            for (int i = 0; i < stat.getAgility(); i++) {
                this.minDamage -= 1;
                this.maxDamage -=4;
            }
        }

        this.stats[index] = null;
    }

    @Override
    public double getItemLeve() {
        double a = ((this.getMinDamage() + this.getMaxDamage()) / 2d);
        a+= this.getStrength() +this.getAgility() +this.getVitality();
        return a;
    }

    @Override
    public String toString() {


        return String.format("%s: %d-%d Damage, +%s Strength, +%d Agility, +%d Vitality",
                this.getName(),this.getMinDamage(),
                this.getMaxDamage(),this.getStrength(),
                this.getAgility(),this.getVitality());
    }

    @Override
    public int compareTo(Weapon o) {
        return Double.compare(this.getItemLeve(),o.getItemLeve());
    }


    private int getStrength(){
        int strength = 0;
        for (Stat stat : stats) {
            if (stat != null){
                strength += stat.getStrength();
            }

        }
        return strength;
    }

    private int getAgility(){
        int agility = 0;
        for (Stat stat : stats) {
            if (stat != null){
                agility += stat.getAgility();
            }
        }
        return agility;
    }

    private int getVitality(){
        int vitality = 0;
        for (Stat stat : stats) {
            if (stat != null){
                vitality += stat.getVitality();
            }

        }
        return vitality;
    }
}
