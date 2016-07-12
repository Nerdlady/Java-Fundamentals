package com.company._12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String,Rectangle> rectangles = new LinkedHashMap<>();
        String[] info = reader.readLine().split("[\\s]+");
        int firstLine = Integer.parseInt(info[0]);
        int second = Integer.parseInt(info[1]);

        for (int i = 0; i < firstLine; i++) {
            String[] params = reader.readLine().trim().split("[\\s]+");
            String id= params[0].trim();
            double width = Double.parseDouble(params[1]);
            double height =  Double.parseDouble(params[2]);
            double x =  Double.parseDouble(params[3]);
            double y =  Double.parseDouble(params[4]);
            Rectangle rectangle = new Rectangle(id,width,height,y,x);
            rectangles.put(id,rectangle);
        }

        for (int i = 0; i < second; i++) {
            String[] toGet = reader.readLine().trim().split("[\\s]+");
            String first = toGet[0].trim();
            String seccond = toGet[1].trim();
            Rectangle oneRec = rectangles.get(first);
            Rectangle twoRec = rectangles.get(seccond);

                System.out.println(oneRec.overlaps(twoRec));


        }
    }


}

class Rectangle{
    String id;
    double width;
    double height;
    double x;
    double y;
     double x2;
     double y2;

    public Rectangle(String id, double width, double height, double y, double x) {
        this.id = id;
        this.width = width;
        this.height = height;
        this.y = y;
        this.x = x;
        this.x2 = x + this.width;
        this.y2 = y + this.height;
    }

    public boolean overlaps (Rectangle other) {


        return this.x <= other.x2&&other.x <= this.x2 && this.y <= other.y2 &&other.y <= this.y2;
    }
}
