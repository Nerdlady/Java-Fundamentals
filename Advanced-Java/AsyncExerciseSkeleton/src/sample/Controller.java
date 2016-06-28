package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sun.awt.windows.ThemeReader;

public class Controller {
    @FXML
    TextField fromBox;
    @FXML
    TextField toBox;
    @FXML
    TextArea outputArea;
    Thread threadFirst;
    Thread threadSecond;
    Thread thirh;
    Thread print;

    @FXML
    void onStart(ActionEvent actionEvent) {
        outputArea.clear();
        int from = Integer.parseInt(fromBox.getText());
        int to = Integer.parseInt(toBox.getText());

        printPrimesInRange(from, to);
    }

    void printPrimesInRange(int from, int to) {
        int first = (from + to) / 3;
        int second = (first + to) / 2;

        StringBuilder primesBuilder = new StringBuilder();
        StringBuilder primesBuilderSecond = new StringBuilder();
        StringBuilder primesBuilderThirh = new StringBuilder();

        threadFirst = new Thread(() -> {
            for (int number = from; number < first; number++) {
                boolean isPrime = true;
                for (int divider = 2; divider < number; divider++) {
                    if (number % divider == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    primesBuilder.append(String.format("%d%n", number));
                }
            }

        }
        );

        threadSecond = new Thread(() -> {
            for (int number = first; number < second; number++) {
                boolean isPrime = true;
                for (int divider = 2; divider < number; divider++) {
                    if (number % divider == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    primesBuilderSecond.append(String.format("%d%n", number));
                }
            }

        }
        );

        thirh = new Thread(() -> {
            for (int number = second; number < to; number++) {
                boolean isPrime = true;
                for (int divider = 2; divider < number; divider++) {
                    if (number % divider == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    primesBuilderThirh.append(String.format("%d%n", number));
                }
            }
            //print.start();
        }
        );

        threadFirst.start();
        threadSecond.start();
        thirh.start();

        print=  new Thread(() -> {
            primesBuilder.append(primesBuilderSecond.append(primesBuilderThirh));


            outputArea.appendText(primesBuilder.toString());
        });

        while (true){
            if (!threadFirst.isAlive() && !threadSecond.isAlive() &&!thirh.isAlive()){
                print.start();
                break;
            }
        }



    }

    @FXML
    void onStop(ActionEvent actionEvent) {
        // TODO: stop finding primes and print the ones found so far
        threadFirst.interrupt();
        threadSecond.interrupt();
        thirh.interrupt();
        print.start();

    }
}
