package com.company;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, LinkedHashMap<String, ArrayList>> data = new TreeMap<>();
        Pattern pattern = Pattern.compile("IP=([A-ZA-z0-9:\\.]*)\\s+message=\\s*?'(.*)'\\s+user=(\\w+)");
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("end")) {
                break;
            }
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                String name = matcher.group(3);
                String ip = matcher.group(1);
                String message = matcher.group(2);

                if (!data.containsKey(name)) {
                    data.put(name, new LinkedHashMap<>());
                }

                if (!data.get(name).containsKey(ip)) {
                    data.get(name).put(ip, new ArrayList());
                }

                data.get(name).get(ip).add(message);
            }
        }


        for (Map.Entry<String, LinkedHashMap<String, ArrayList>> user : data.entrySet()) {
            System.out.printf("%s: %n", user.getKey());
            StringBuilder bilder = new StringBuilder();
            for (Map.Entry<String, ArrayList> ip : user.getValue().entrySet()) {
               bilder.append(String.format("%s => %d, ", ip.getKey(), ip.getValue().size()));
            }

            bilder.delete(bilder.length() - 2,bilder.length());
            bilder.append(".");
            System.out.println(bilder.toString());
        }
    }
}
