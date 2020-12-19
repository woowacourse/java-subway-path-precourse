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
        CommandType commandType = requestCommandNumber();
        while (isRunning(commandType)) {
            runDetailAction(commandType);
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
                OutputView.printMainScreen(CommandType.getInfos());
            }
        }

        return commandType;
    }

    private boolean isRunning(CommandType commandType) {
        return !commandType.isExit();
    }
    
    private void runDetailAction(CommandType commandType) {

    }
}
