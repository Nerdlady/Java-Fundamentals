package com.company._02KingGambit;

import com.company._02KingGambit.interfaces.Soldier;
import com.company._02KingGambit.listeners.Footman;
import com.company._02KingGambit.listeners.RoyalGuard;
import com.company._02KingGambit.models.King;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String,Soldier> soldiers = new HashMap<>();
        String kingName = reader.readLine();
        King king = new King(kingName);
        String[] royalGuardsNames = reader.readLine().split("\\s+");
        String[] soldiersNames = reader.readLine().split("\\s+");

        for (String royalGuardName : royalGuardsNames) {
            Soldier royalGuard = new RoyalGuard(royalGuardName);
            king.addUnderAttackListener(royalGuard);
            royalGuard.addDeathListener(king);
            soldiers.put(royalGuardName,royalGuard);
        }

        for (String soldierName : soldiersNames) {
            Soldier soldier = new Footman(soldierName);
            king.addUnderAttackListener(soldier);
            soldier.addDeathListener(king);
            soldiers.put(soldierName,soldier);
        }

        while (true){
            String line = reader.readLine();
            if (line.equals("End")){
                break;
            }

            String[] commands = line.split("\\s+");
            switch (commands[0]) {
                case "Attack":
                    king.respondToAttack();
                    break;
                case "Kill":
                    Soldier soldier = soldiers.get(commands[1]);
                   soldier.respondToAttack();
                    break;

            }
        }
    }
}
