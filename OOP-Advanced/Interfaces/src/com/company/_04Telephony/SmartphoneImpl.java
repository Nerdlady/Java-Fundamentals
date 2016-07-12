package com.company._04Telephony;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SmartphoneImpl implements Smartphone {

    @Override
    public void browingWeb(String... sites) {
        Pattern phonePattern = Pattern.compile("\\d+");
        for (String site : sites) {
            Matcher matcher = phonePattern.matcher(site);
            if (matcher.find()){
                System.out.println("Invalid URL!");
            } else {
                System.out.printf("Browsing: %s!%n",site);
            }
        }
    }

    @Override
    public void call(String... numbers) {
        Pattern phonePattern = Pattern.compile("\\D+");
        for (String number : numbers) {
            Matcher matcher = phonePattern.matcher(number);
            if (matcher.find()){
                System.out.println("Invalid number!");
            } else {
                System.out.printf("Calling... %s%n",number);
            }
        }
    }
}
