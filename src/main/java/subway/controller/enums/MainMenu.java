package subway.controller.enums;

import subway.controller.PathController;
import subway.view.OutputView;

import java.util.Arrays;
import java.util.Scanner;

public enum MainMenu {
    FIND_PATH("1", PathController.getInstance(new Scanner(System.in))::run),
    EXIT("Q", OutputView::printExit);

    private String type;
    private Runnable expression;
    private static final String ERROR_INVALID_MENU = "[ERROR] 선택할 수 없는 기능입니다.";

    MainMenu(String type, Runnable expression) {
        this.type = type;
        this.expression = expression;
    }

    public void run() {
        this.expression.run();
    }

    public String getType() {
        return this.type;
    }

    public static MainMenu findMainMenu(String selectedMenu) {
        return Arrays.stream(MainMenu.values())
                .filter(mainMenu -> mainMenu.type.equals(selectedMenu))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_INVALID_MENU));
    }
}