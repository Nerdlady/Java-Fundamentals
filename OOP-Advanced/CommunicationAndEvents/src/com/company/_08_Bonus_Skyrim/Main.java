package com.company._08_Bonus_Skyrim;

import com.company._08_Bonus_Skyrim.events.GiveAuraEvent;
import com.company._08_Bonus_Skyrim.interfaces.Dragon;
import com.company._08_Bonus_Skyrim.interfaces.Warrior;
import com.company._08_Bonus_Skyrim.listeners.WarriorSet;
import com.company._08_Bonus_Skyrim.models.DragonImpl;
import com.company._08_Bonus_Skyrim.models.WarriorImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        WarriorSet warriors = new WarriorSet();
        String[] dragonInfo = reader.readLine().split("\\s+");
        Dragon dragon = new DragonImpl(dragonInfo[0],Integer.parseInt(dragonInfo[1]),Integer.parseInt(dragonInfo[2]),dragonInfo[3]);

        while (true){
            String line = reader.readLine();
            if (line.equals("Skyrim")){
                break;
            }

            String[] warriorInfo = line.split("\\s+");
            Warrior warrior = new WarriorImpl(warriorInfo[0],Integer.parseInt(warriorInfo[1]),Integer.parseInt(warriorInfo[2]),Integer.parseInt(warriorInfo[3]));
            warrior.addWarriorDeadListener(warriors);
            warriors.add(warrior);
        }

        dragon.addAttackListener(warriors);
        dragon.addDragonDeadListener(warriors);
        warriors.addAllWarriorsDeadListener(dragon);
        GiveAuraEvent auraEvent = new GiveAuraEvent(warriors.first());
        warriors.handleGivePower(auraEvent);

        while (true){
            if (dragon.isAlive() && warriors.size() > 0){
                dragon.attackWarrior(warriors.first());
                for (Warrior warrior : warriors) {
                    warrior.attackDragon(dragon);
                }
            } else {
                break;
            }
        }
    }
}
