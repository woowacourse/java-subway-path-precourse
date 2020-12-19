package subway;

import subway.controller.MainController;
import subway.initializer.AppInitializer;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        AppInitializer.run();
        MainController mainController = new MainController(scanner);
        mainController.run();

    }
}
