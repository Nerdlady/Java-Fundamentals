package com.company;


import sun.security.krb5.SCDynamicStoreConfig;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SemanticHTML {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern startDiv = Pattern.compile("<(div )(.*?)((id|class)\\s*?=\\s*?\\\"(\\w+)\\\")");
        Pattern endDiv = Pattern.compile("<\\/(div)>\\s*?(<!--\\s*?(\\w+)\\s*-->)");
        Pattern end = Pattern.compile("\\s*?<(.*)>");


        LinkedList<String> input = new LinkedList();
        LinkedList<String> output = new LinkedList();

        String line = scanner.nextLine();

        while (!line.equals("END")) {
            input.add(line);
            line = line = scanner.nextLine();
        }

        for (String text : input) {
            String c = text;

            Matcher matcher = startDiv.matcher(text);

            if (matcher.find()) {

                String b = text.replace(matcher.group(1).toString().trim(), matcher.group(5).toString().trim());
                c = b.replace(matcher.group(3).toString(), "");
                Matcher matcher1 = end.matcher(c);
                if (matcher1.find()) {
                    String i = matcher1.group(1);

                    String q = i.replaceAll( "\\s+", " ");
                    c = c.replace(matcher1.group(1), q.trim());
                }


            }

            Matcher matcher1 = endDiv.matcher(text);

            if (matcher1.find()) {

                String b = text.replace(matcher1.group(1).toString().trim(), matcher1.group(3).toString().trim());
                c = b.replace(matcher1.group(2).toString(), "");
                Matcher matcher2 = end.matcher(c);
                if (matcher2.find()) {
                    String i = matcher2.group(1);

                    String q = i.replaceAll( "\\s+", " ");
                    c = c.replace(matcher2.group(1), q.trim());
                }


            }




            output.add(c);
        }

        for(String outLine : output)
        {
            System.out.println(outLine);
        }
    }
}
