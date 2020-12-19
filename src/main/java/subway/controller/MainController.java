package subway.controller;

import subway.view.InputView;

import java.util.Scanner;

public class MainController {
    InputView inputView;

    public MainController(Scanner scanner) {
        inputView = new InputView(scanner);
    }

    public void run() {
    }
}
