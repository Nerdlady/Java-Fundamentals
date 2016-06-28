package com.company;


import java.util.*;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, TreeMap<String, Dragon>> data = new LinkedHashMap<>();

        for (int i = 0; i < lines; i++) {
            String[] line = scanner.nextLine().split("\\s+");
            String type = line[0];
            String name = line[1];
            String damageSTr = line[2];
            String healthStr = line[3];
            String armorStr = line[4];
            int damage = 0;
            int healt = 0;
            int armor = 0;

            if (damageSTr.equals("null")) {
                damage = 45;
            } else {
                damage = Integer.parseInt(damageSTr);
            }
            if (healthStr.equals("null")) {
                healt = 250;
            } else {
                healt = Integer.parseInt(healthStr);
            }
            if (armorStr.equals("null")) {
                armor = 10;
            } else {
                armor = Integer.parseInt(armorStr);
            }


            if (!data.containsKey(type)) {
                data.put(type, new TreeMap<>());
            }


            if (!data.get(type).containsKey(name)) {
                data.get(type).put(name, new Dragon());
            }
            data.get(type).get(name).health1 = healt;
            data.get(type).get(name).damage1 = damage;
            data.get(type).get(name).armor1 = armor;

        }

        data.entrySet().stream().forEach(a -> {
            double damageCOunt = 0;
            double hCount = 0;
            double aCount = 0;
            int count = 0;
            for (Map.Entry<String, Dragon> dragon : a.getValue().entrySet()) {
                damageCOunt += dragon.getValue().getDamage();
                hCount += dragon.getValue().getHealth();
                aCount += dragon.getValue().getArmor();
                count++;
            }
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", a.getKey(), damageCOunt/count, hCount/count, aCount/count);

            for (Map.Entry<String, Dragon> dragon : a.getValue().entrySet()) {
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", dragon.getKey(), dragon.getValue().getDamage(), dragon.getValue().getHealth(), dragon.getValue().getArmor());
            }
        });
    }
}

class Dragon {

    Integer damage1;
    Integer health1;
    Integer armor1;



    public int getDamage() {
        return damage1;
    }

    public int getHealth() {
        return health1;
    }

    public int getArmor() {
        return armor1;
    }


}
