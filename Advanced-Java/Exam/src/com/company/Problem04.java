package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.TreeMap;

public class Problem04 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, TreeMap<String, Long>> data = new TreeMap<>();

        while (true) {
            String line = reader.readLine();
            if (line.equals("Count em all")) {
                break;
            }

            String[] info = line.split("->");
            String name = info[0].trim();
            String type = info[1].trim();
            int count = Integer.parseInt(info[2].trim());


            if (!data.containsKey(name)) {
                data.put(name, new TreeMap<>());
                data.get(name).put("Red", 0l);
                data.get(name).put("Green", 0l);
                data.get(name).put("Black", 0l);
            }

            long result = data.get(name).get(type) + count;
            data.get(name).put(type, result);
            if (data.get(name).get("Green") >= 1_000_000) {


                type = "Red";
                long del = result / 1_000_000;
                long toDelete = 1_000_000;
                if (del != 1) {
                    toDelete *= del;
                }

                data.get(name).put("Green", data.get(name).get("Green") - toDelete);
                data.get(name).put(type, data.get(name).get(type) + del);


            }

            if (data.get(name).get("Red") >= 1_000_000) {

                type = "Black";
                long del = result / 1_000_000;
                long toDelete = 1_000_000;
                if (del != 1) {
                    toDelete *= del;
                }

                data.get(name).put("Red", data.get(name).get("Red") - toDelete);


                data.get(name).put(type, data.get(name).get(type) + del);


            }

        }

        data.entrySet().stream().sorted((a, b) -> {
            int result = Long.compare(b.getValue().get("Black"), a.getValue().get("Black"));
            if (result == 0) {
                result = Long.compare(a.getKey().length(), b.getKey().length());
            }
            return result;
        }).forEach(a -> {
            System.out.println(a.getKey());
            a.getValue().entrySet().stream().sorted((c, b) -> {
                int recult = Long.compare(b.getValue(), c.getValue());
                return recult;
            }).forEach(c -> {
                System.out.printf("-> %s : %d%n", c.getKey(), c.getValue());
            });
        });
    }
}
