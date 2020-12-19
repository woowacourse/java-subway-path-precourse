package controller;

import java.util.Arrays;
import view.InputView;
import view.OutputView;

public class MainController {
    private static final String DOT = ". ";
    private static final String SELECT_FUCTION = "## 원하는 기능을 선택하세요.";

    public void run() {
        while (true) {
            showMenu();
            String input = InputView.inputWithHintMessage(SELECT_FUCTION);
            if (input.equals(MainMenu.EXIT_PROGRAM.getValue())) {
                break;
            }
            OutputView.printNewLine();
        }
    }

    public void showMenu() {
        OutputView.print(MainMenu.MENU_NAME);
        Arrays.stream(MainMenu.values()).forEach(
                mainMenu -> OutputView.print(mainMenu.getValue() + DOT + mainMenu.getAction()));
        OutputView.printNewLine();
    }
}
