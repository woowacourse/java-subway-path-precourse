package subway;

import java.util.Scanner;
import subway.controller.Controller;
import subway.controller.MainMenuController;
import subway.view.InputView;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final InputView inputView = new InputView(scanner);
        final Controller mainMenuController = new MainMenuController(inputView);

        do {
            mainMenuController.run();
        } while(MainMenuController.isRunning);
    }
}
