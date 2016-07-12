package _07;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShapesVolume {
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
                    case "Cube":
                        Cube cube = new Cube(Double.parseDouble(info[1]));
                        System.out.printf("%.3f%n",Calculations.volumeCube(cube));
                        break;
                    case "Cylinder":
                        Cylinder cylinder = new Cylinder(Double.parseDouble(info[1]), Double.parseDouble(info[2]));
                        System.out.printf("%.3f%n",Calculations.volumeCylinder(cylinder));
                        break;
                    case "TrianglePrism":
                        Triangle triangle = new Triangle(Double.parseDouble(info[1]), Double.parseDouble(info[2]), Double.parseDouble(info[3]));
                        System.out.printf("%.3f%n",Calculations.volumeTriangle(triangle));
                        break;
                }


            } catch (Exception e) {
                break;
            }

        }

    }
}

class Calculations {

    static double volumeCube(Cube cube) {
        return Math.pow(cube.length, 3);
    }

    static double volumeTriangle(Triangle triangle) {
        return (triangle.height * triangle.length * triangle.side) / 2;
    }

    static double volumeCylinder(Cylinder cylinder) {
        return (cylinder.radius * cylinder.radius) * cylinder.height * Math.PI;
    }
}

class Triangle {
    double side;
    double height;
    double length;

    public Triangle(double side, double height, double length) {
        this.side = side;
        this.height = height;
        this.length = length;
    }
}

class Cube {
    double length;

    public Cube(double length) {
        this.length = length;
    }
}

class Cylinder {
    double radius;
    double height;

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }
}


