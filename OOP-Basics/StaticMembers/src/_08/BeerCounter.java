package _08;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BeerCounter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = reader.readLine();
            try {
                if (line.equals("End") || line.isEmpty() || line == null) {
                    break;
                }

                String[] beers = line.split("\\s+");
                int beersBuy = Integer.parseInt(beers[0]);
                int drinkedBeer = Integer.parseInt(beers[1]);

                Beer.addBeer(beersBuy);
                Beer.drinkBeer(drinkedBeer);

            } catch (Exception e) {
                break;
            }

        }

        System.out.printf("%d %d", Beer.getBeersInStock(), Beer.getBeersDrinked());
    }
}

class Beer {
    private static int beersInStock;
    private static int beersDrinked;

    static {
        beersInStock = 0;
        beersDrinked = 0;
    }


    public static void addBeer(int beers) {
        beersInStock += beers;

    }

    public static void drinkBeer(int beers) {
        beersDrinked += beers;
        beersInStock -= beers;
    }

    public static int getBeersInStock() {
        return beersInStock;
    }

    public static int getBeersDrinked() {
        return beersDrinked;
    }
}
