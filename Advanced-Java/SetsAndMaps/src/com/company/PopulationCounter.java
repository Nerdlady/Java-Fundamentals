package com.company;

import java.util.*;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String,HashMap<String,Long>> data = new LinkedHashMap<>();

        while (true){
            String line = scanner.nextLine();

            if (line.equals("report")){
                break;
            }

            String[] info = line.split("\\|");
            String country = info[1];
            String city = info[0];
            Long populatiion = Long.parseLong(info[2]);

            if (!data.containsKey(country)){
                data.put(country,new LinkedHashMap<>());
            }

            if (!data.get(country).containsKey(city)){
                data.get(country).put(city,0l);
            }

            Long totalPopulation = data.get(country).get(city) + populatiion;
            data.get(country).put(city,populatiion);
        }

        data.entrySet().stream().sorted((a,b) -> {

            long sizaOne = 0l;
            long sizeTwo = 0l;
            for (Map.Entry<String, Long> stringLongEntry : a.getValue().entrySet()) {
                sizaOne +=stringLongEntry.getValue();
            }
            for (Map.Entry<String, Long> stringLongEntry : b.getValue().entrySet()) {
                sizeTwo +=stringLongEntry.getValue();
            }

            int result = Long.compare(sizeTwo,sizaOne);
            return result;
        }).forEach(a ->{
            long sizaOne = 0l;
            for (Map.Entry<String, Long> stringLongEntry : a.getValue().entrySet()) {
                sizaOne +=stringLongEntry.getValue();
            }
            System.out.printf("%s (total population: %d)%n",a.getKey(),sizaOne);

            a.getValue().entrySet().stream().sorted((c,b) ->{

                int result = Long.compare(b.getValue(),c.getValue());
                return result;
            }).forEach(v-> {
                System.out.printf("=>%s: %d%n", v.getKey(),v.getValue());
            });
        });
    }
}
