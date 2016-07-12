package _04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class ShoppingSpree {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, Product> products = new LinkedHashMap<>();
        LinkedHashMap<String, Person> people = new LinkedHashMap<>();

        try {
            String peopleInput = reader.readLine();
            String[] peopleInfo = peopleInput.split(";");
            for (String info : peopleInfo) {

                String[] information = info.split("=");
                String name = information[0];
                double money = Double.parseDouble(information[1]);
                Person person = new Person(name, money);

                people.put(name, person);


            }

            String productsInput = reader.readLine();
            String[] productsInfo = productsInput.split(";");
            for (String info : productsInfo) {

                String[] information = info.split("=");
                String name = information[0];
                double money = Double.parseDouble(information[1]);
                Product product = new Product(name, money);

                products.put(name, product);


            }

            while (true) {
                String line = reader.readLine();
                if (line.equals("END")) {
                    break;
                }

                String[] info = line.split("\\s+");
                String buyerName = info[0];
                String buyedProduct = info[1];
                people.get(buyerName).buyProduct(products.get(buyedProduct));
            }

            for (Map.Entry<String, Person> person : people.entrySet()) {
                System.out.printf("%s - %s%n", person.getKey(), person.getValue().allProducts());
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }

}

class Person {
    private String name;
    private double money;
    private LinkedList<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products = new LinkedList<>();
    }

    public void buyProduct(Product product) {
        if (this.money < product.getCost()) {
            System.out.printf("%s can't afford %s%n", this.name, product.getName());
            return;
        }

        this.products.add(product);
        this.money -= product.getCost();
        System.out.printf("%s bought %s%n", this.name, product.getName());
    }

    public void setName(String name) {
        if (name.trim().length() ==0){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }


    public void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public String allProducts() {
        StringBuilder builder = new StringBuilder();
        if (products.size() > 0) {
            for (Product product : products) {
                builder.append(product.getName()).append(", ");
            }
            builder = new StringBuilder(builder.substring(0, builder.length() - 2));
        } else {
            builder.append("Nothing bought");
        }

        return builder.toString();
    }

    public LinkedList<Product> getProducts() {
        return products;
    }
}

class Product {
    private String name;
    private double cost;

    public Product(String name, double cost) {
        setName(name);
        setCost(cost);

    }

    public void setName(String name) {
        if (name.trim().length() ==0){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public void setCost(double cost) {
        if (cost < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }
}
