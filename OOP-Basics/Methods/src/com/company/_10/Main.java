package com.company._10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String datOne = reader.readLine();
        String dateTwo = reader.readLine();
        DateModifier.calculateDifference(datOne,dateTwo);
        System.out.println(DateModifier.getDifference());
    }
}
 class DateModifier {
     static long difference;

     public static void calculateDifference(String dateOne, String dateTwo){
         String[] dateOneInfo = dateOne.split("\\s+");
         int year = Integer.parseInt(dateOneInfo[0]);
         int mounth = Integer.parseInt(dateOneInfo[1]);
         int days = Integer.parseInt(dateOneInfo[2]);

         String[] dateTwoInfo = dateTwo.split("\\s+");
         int year2 = Integer.parseInt(dateTwoInfo[0]);
         int mounth2 = Integer.parseInt(dateTwoInfo[1]);
         int days2 = Integer.parseInt(dateTwoInfo[2]);

         Calendar one = Calendar.getInstance();
         Calendar two = Calendar.getInstance();

         one.set(year,mounth,days);
         two.set(year2,mounth2,days2);


         long firstMil = one.getTimeInMillis();
         long secondMil = two.getTimeInMillis();
         difference = Math.abs(daysDiff(firstMil,secondMil));

     }

     public static long getDifference() {
         return difference;
     }

     private static long daysDiff(long from, long to) {
         return  (to - from) / (24 * 60 * 60 * 1000) ;
     }

 }

//86400000