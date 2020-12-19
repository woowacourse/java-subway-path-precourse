package subway.controller.enums;

import subway.service.PathService;

import java.util.Arrays;
import java.util.function.Supplier;

public enum PathMenu {
    SHORTEST_PATH("1", PathService::findShortestDistancePath),
    MINIMUM_TIME("2", PathService::findMinimumTimePath),
    BACK("B", () -> Boolean.TRUE);

    private String type;
    private Supplier<Boolean> expression;
    private static final String ERROR_INVALID_MENU = "[ERROR] 선택할 수 없는 기능입니다.";

    PathMenu(String type, Supplier<Boolean> expression) {
        this.type = type;
        this.expression = expression;
    }

    public boolean run() {
        return this.expression.get();
    }

    public static PathMenu findMainMenu(String selectedMenu) {
        return Arrays.stream(PathMenu.values())
                .filter(mainMenu -> mainMenu.type.equals(selectedMenu))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_INVALID_MENU));
    }
}