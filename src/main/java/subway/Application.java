package subway;

import java.util.Scanner;
import subway.controller.MainController;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        MainController mainController = new MainController(scanner);
        mainController.run();
        scanner.close();
    }
}
