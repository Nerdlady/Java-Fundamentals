package _03;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        while (true){
            String line = reader.readLine();
            try {
                if (line.equals("End") || line.isEmpty() || line == null){
                    break;
                }

                String[] info = line.split("\\s+");
                switch (info[1]){
                    case "Celsius":
                        System.out.printf("%.2f Fahrenheit",celToFar(Integer.parseInt(info[0]) ));
                        break;
                    case "Fahrenheit":
                        System.out.printf("%.2f Celsius",farToCel(Integer.parseInt(info[0]) ));
                        break;

                }


            } catch (Exception e){
                break;
            }

        }
    }

    static double celToFar(int cel){
        return cel * 1.8 + 32;
    }

    static double farToCel(int far){
        return (far - 32) / 1.8;
    }
}
