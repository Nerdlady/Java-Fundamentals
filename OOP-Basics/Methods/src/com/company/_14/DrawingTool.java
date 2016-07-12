package com.company._14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DrawingTool {
    public static void main(String[] args) throws IOException {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CorDraw corDraw = null;
        String line = reader.readLine();

        switch (line){
            case "Square":
                int size = Integer.parseInt(reader.readLine());
                Square square = new Square(size);
                corDraw = new CorDraw(square);
                break;
            case "Rectangle":
                int widht = Integer.parseInt(reader.readLine());
                int height = Integer.parseInt(reader.readLine());
                Rectngle rectngle = new Rectngle(widht,height);
                corDraw = new CorDraw(rectngle);
                break;
        }

        corDraw.drawFigure();
    }
}

class CorDraw{
    Ficure ficure;

    public CorDraw(Ficure ficure) {
        this.ficure = ficure;
    }

    public void drawFigure(){
        ficure.Draw();
    }
}

abstract class Ficure{
    int weight;
    int height;

    public Ficure(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    public void Draw() {
        for (int i = 0; i < height ; i++) {
            for (int j = 0; j <= weight + 1; j++) {
                if (j == 0 || j == weight +1 ){
                    System.out.printf("|");
                    continue;
                }

                if (i == 0 || i == height - 1){
                    System.out.printf("-");
                } else {
                    System.out.printf(" ");
                }
            }
            System.out.println();
        }
    }
}

class Rectngle extends Ficure{


    public Rectngle(int weight, int height) {
        super(height,weight);
    }


}

class Square extends Ficure{


    public Square(int size) {
       super(size,size);
    }


}
