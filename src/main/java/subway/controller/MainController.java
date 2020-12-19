package subway.controller;

import subway.domain.CommandType;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class MainController {
    private final InputView inputView;

    public MainController(Scanner scanner) {
        this.inputView = new InputView(scanner);
    }

    public void run() {
        OutputView.printMainScreen(CommandType.getInfos());
        CommandType commandType = inputView.inputCommandNumber();
    }
}
