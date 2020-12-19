package subway;

import subway.controller.Controller;
import subway.controller.MainController;

public class Application {

    public static void main(String[] args) {
        Controller mainController = new MainController();
        mainController.run();
    }
}
