package subway.domain;

import subway.controller.RouteController;
import subway.utils.exception.InvalidMenuInputException;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public enum MainMenu {
    SHOW_ROUTE("1", "1. 경로 조회\n", RouteController::run),
    QUITE("Q", "Q. 종료\n", null);

    private String button;
    private String menu;
    private Runnable runnable;

    MainMenu(String button, String menu, Runnable runnable) {
        this.button = button;
        this.menu = menu;
        this.runnable = runnable;
    }

    public static List<String> list() {
        return Arrays.stream(MainMenu.values())
                .map(mainMenu -> mainMenu.menu)
                .collect(Collectors.toList());
    }

    public static MainMenu setRunningState() {
        return MainMenu.SHOW_ROUTE;     // just for maintaining running state
    }

    public boolean isRunning() {
        return !Objects.equals(MainMenu.QUITE, this);
    }

    public static MainMenu findMenu(String name) {
        return Arrays.stream(MainMenu.values())
                .filter(menu -> Objects.equals(menu.button, name))
                .findAny()
                .orElseThrow(() -> new InvalidMenuInputException());
    }

    public void start() {
        if (isRunning()) {
            runnable.run();
        }
    }
}
