package subway.view;

import subway.controller.MainFunction;

public class OutputView {

    public static final String ERROR_PREFIX = "[ERROR] ";

    public static void printError(Exception e) {
        System.out.println(ERROR_PREFIX + e.getMessage());
    }

    public static void printMainFunction(MainFunction mainFunction) {
        System.out.println(mainFunction);
    }
}
