package subway.controller;

import subway.domain.CommandType;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class MainController {
    private final InputView inputView;
    private final PathController pathController;

    public MainController(Scanner scanner) {
        this.inputView = new InputView(scanner);
        this.pathController = new PathController(inputView);
    }

    public void run() {
        OutputView.printMainScreen(CommandType.getInfos());
        CommandType commandType = requestCommandNumber();
        while (isRunning(commandType)) {
            runDetailAction();
            OutputView.printMainScreen(CommandType.getInfos());
            commandType = requestCommandNumber();
        }
    }

    private CommandType requestCommandNumber() {
        CommandType commandType = CommandType.EXIT;

        while(true) {
            try {
                commandType = inputView.inputCommandNumber();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return commandType;
    }

    private boolean isRunning(CommandType commandType) {
        return !commandType.isExit();
    }

    private void runDetailAction() {
        pathController.run();
    }
}
