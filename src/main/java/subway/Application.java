package subway;

import subway.controller.Controller;
import subway.controller.MainController;

public class Application {

    public static void main(String[] args) {
        Initializer.init();
        Controller mainController = new MainController();
        mainController.run();
    }
}
