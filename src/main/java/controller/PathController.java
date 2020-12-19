package controller;

import java.util.Arrays;
import view.InputView;
import view.OutputView;

public class PathController {
    private static final String DOT = ". ";
    private static final String SELECT_FUCTION = "## 원하는 기능을 선택하세요.";
    private static final String INPUT_START_STATION = "## 출발역을 입력하세요.";
    private static final String INPUT_DESTINATION_STATION = "## 도착역을 입력하세요.";

    public void run() {
        showMenu();
        String input = InputView.inputWithHintMessage(SELECT_FUCTION);
        if (input.equals(PathMenu.GO_BACK.getValue())) {
            return;
        }
        processInput(input);
        OutputView.printNewLine();
    }

    private void showMenu() {
        OutputView.print(PathMenu.MENU_NAME);
        Arrays.stream(PathMenu.values()).forEach(
                pathMenu -> OutputView.print(pathMenu.getValue() + DOT + pathMenu.getAction()));
        OutputView.printNewLine();
    }

    private void processInput(String input) {
        String from = InputView.inputWithHintMessage(INPUT_START_STATION);
        String to = InputView.inputWithHintMessage(INPUT_DESTINATION_STATION);

        if (input.equals(PathMenu.PIVOT_SHORTEST_DISTANCE)) {

        }
        if (input.equals(PathMenu.PIVOT_SHORTEST_TIME)) {

        }
    }

}
