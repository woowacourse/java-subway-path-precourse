package subway.controller;

import java.util.Arrays;
import subway.exception.InputException;
import subway.exception.SystemExitException;
import subway.view.OutputView;

public enum MainFunction {
    RETRIEVE_ROUTE("1", "경로 조회", MainFunction::goToRouteController),
    EXIT_SYSTEM("Q", "종료", MainFunction::exitSystem);

    private static final RouteController routeController = new RouteController();

    private final String button;
    private final String detail;
    private final Runnable runnable;

    MainFunction(String button, String detail, Runnable runnable) {
        this.button = button;
        this.detail = detail;
        this.runnable = runnable;
    }

    public static void printFunctions() {
        OutputView.printMainFunction(MainFunction.values());
    }

    public static void runFunction(String inputString) {
        Arrays.stream(MainFunction.values())
                .filter(mainFunction -> mainFunction.button.equals(inputString))
                .findAny()
                .orElseThrow(InputException::new)
                .runnable.run();
    }

    private static void goToRouteController() {
        routeController.run();
    }

    private static void exitSystem() {
        throw new SystemExitException();
    }

    @Override
    public String toString() {
        return button + ". " + detail;
    }
}
