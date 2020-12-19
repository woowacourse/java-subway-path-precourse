package subway.controller;

import subway.domain.CommandType;
import subway.view.OutputView;

import java.util.Scanner;

public class MainController {
    private final Scanner scanner;

    public MainController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        OutputView.printMainScreen(CommandType.getInfos());
    }
}
