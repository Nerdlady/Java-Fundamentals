package _01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double lenght = Double.parseDouble(reader.readLine());
        double width = Double.parseDouble(reader.readLine());
        double height = Double.parseDouble(reader.readLine());
        Class boxClass = Box.class;
        Field[] fields = boxClass.getDeclaredFields();
        System.out.println(Arrays.asList(fields)
                .stream()
                .filter(f -> Modifier.isPrivate(f.getModifiers())).count());
    try {
        Box box = new Box(lenght, width, height);
        System.out.printf("Surface Area - %.2f%n", box.calculteArea());
        System.out.printf("Lateral Surface Area - %.2f%n", box.calculateLateralArea());
        System.out.printf("Volume - %.2f%n", box.calculateVolume());
    }catch (IllegalArgumentException e){
        System.out.println(e.getMessage());
    }



    }
}

class Box {
    private double lengt;
    private double width;
    private double height;

    public Box(double lengt, double width, double height) {
        setHeight(height);
        setLengt(lengt);
        setWidth(width);
    }

    private void setLengt(double lengt) {
        if (lengt <=0) {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.lengt = lengt;
    }

    private void setWidth(double width) {
        if (width <=0) {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    private void setHeight(double height) {
        if (height <=0) {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.height = height;
    }

    public double calculteArea() {

        return 2 * this.lengt * this.width + 2 * this.lengt * this.height + 2 * this.width * this.height;
    }

    public double calculateVolume() {
        return this.lengt * this.width * this.height;
    }

    public double calculateLateralArea() {
        return (2 * this.lengt * this.height) + (2 * this.width * this.height);
    }
}
