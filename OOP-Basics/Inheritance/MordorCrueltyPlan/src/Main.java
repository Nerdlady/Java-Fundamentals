import foods.Food;
import moods.Mood;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
         String[] info = reader.readLine().split("\\s+");
        int gandalfPoints = 0;
        for (String food : info) {
            Food currentFood = FoodFactory.create(food);
            gandalfPoints = gandalfPoints + currentFood.getPoints();
        }

        System.out.println(gandalfPoints);
        Mood mood = MoodFactory.createMood(gandalfPoints);
        System.out.println(mood.getMood());

    }
}
