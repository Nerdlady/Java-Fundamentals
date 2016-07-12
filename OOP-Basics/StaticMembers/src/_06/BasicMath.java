package _06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BasicMath {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = reader.readLine();
            try {
                if (line.equals("End") || line.isEmpty() || line == null) {
                    break;
                }

                String[] info = line.split("\\s+");
                switch (info[0]) {
                    case "Sum":

                        System.out.printf("%.2f%n", MathUnil.add(Float.parseFloat(info[1]),Float.parseFloat(info[2])));

                        break;
                    case "Subtract":
                        System.out.printf("%.2f%n", MathUnil.subtraction(Float.parseFloat(info[1]),Float.parseFloat(info[2])));
                        break;
                    case "Multiply":
                        System.out.printf("%.2f%n", MathUnil.multiplication(Float.parseFloat(info[1]),Float.parseFloat(info[2])));
                        break;
                    case "Divide":
                        System.out.printf("%.2f%n", MathUnil.divide(Float.parseFloat(info[1]),Float.parseFloat(info[2])));
                        break;
                    case "Percentage":
                        System.out.printf("%.2f%n",MathUnil.percentage(Float.parseFloat(info[1]),Float.parseFloat(info[2])));


                }


            } catch (Exception e) {
                break;
            }

        }
    }
}

class MathUnil {
    static float add(float one, float two) {
        return one + two;
    }

    static float subtraction(float one, float two) {
        return one - two;
    }

    static float multiplication(float one, float two) {
        return one * two;
    }

    static float divide(float one, float two) {
        return one / two;
    }

    static float percentage(float one, float two) {
        return one * (two / 100);
    }


}
