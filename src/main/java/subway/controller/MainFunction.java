package subway.controller;

import java.util.Arrays;
import subway.exception.InputException;
import subway.view.OutputView;

public enum MainFunction {
    RETRIEVE_ROUTE("1", "경로 조회", () -> {
    }),
    EXIT_SYSTEM("Q", "종료", () -> {
    });

    private final String button;
    private final String detail;
    private final Runnable runnable;

    MainFunction(String button, String detail, Runnable runnable) {
        this.button = button;
        this.detail = detail;
        this.runnable = runnable;
    }

    public static void printFunctions() {
        Arrays.stream(MainFunction.values())
                .forEach(OutputView::printMainFunction);
    }

    public static void runFunction(String inputString) {
        Arrays.stream(MainFunction.values())
                .filter(mainFunction -> mainFunction.button.equals(inputString))
                .findAny()
                .orElseThrow(InputException::new);
    }


    @Override
    public String toString() {
        return button + ". " + detail;
    }
}
