package controller;

import java.util.Arrays;
import view.InputView;
import view.OutputView;

public class PathController {
    private static final String DOT = ". ";
    private static final String SELECT_FUCTION = "## 원하는 기능을 선택하세요.";

    public void run() {
        showMenu();
        String input = InputView.inputWithHintMessage(SELECT_FUCTION);
        OutputView.printNewLine();
    }

    private void showMenu() {
        OutputView.print(PathMenu.MENU_NAME);
        Arrays.stream(PathMenu.values()).forEach(
                pathMenu -> OutputView.print(pathMenu.getValue() + DOT + pathMenu.getAction()));
        OutputView.printNewLine();
    }

}
