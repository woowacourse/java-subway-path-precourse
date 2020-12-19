package subway;

import subway.controller.MainController;
import subway.util.Initialization;
import subway.view.InputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Initialization.set();
        InputView inputView = new InputView(scanner);
        MainController mainController = new MainController(inputView);
        mainController.run();

        scanner.close();
    }
}
