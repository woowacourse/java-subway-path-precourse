package subway.domain;

import subway.controller.RouteController;
import subway.views.OutputConstant;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Supplier;

public enum MainMenu {
    ROUTE_LOOKUP("1", "경로 조회", RouteController::getInstance),
    EXIT_PROGRAM("Q", "종료", () -> {return null;});

    private final String option;
    private final String description;
    private final Supplier<RouteController> routeController;

    MainMenu(String option, String description, Supplier<RouteController> routeController) {
        this.option = option;
        this.description = description;
        this.routeController = routeController;
    }

    public static void execute(String selectedOption, Scanner scanner) {
        Arrays.stream(values())
            .filter(mainMenu -> mainMenu.option.equals(selectedOption))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(OutputConstant.NOT_EXIST_OPTION_ERROR))
            .routeController
            .get()
            .mappingMenu(scanner);
    }

    @Override
    public String toString() {
        return option + OutputConstant.OPTION_SEPARATOR + description;
    }
}
