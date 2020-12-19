package subway.view;

import subway.view.resource.ErrorCode;
import subway.view.resource.Message;
import subway.view.resource.Screen;
import subway.view.screen.ScreenFormat;

import java.util.List;

public class OutputView {
    private static final String SHARP_HEADER = "## ";
    private static final String INFO_HEADER = "[INFO] ";
    private static final String ERROR_HEADER = "[ERROR] ";

    private OutputView() {
    }

    public static void printMessage(Message message) {
        printEnter();
        System.out.println(SHARP_HEADER + message);
    }

    public static void printError(ErrorCode errorCode) {
        printEnter();
        System.out.println(ERROR_HEADER + errorCode);
    }

    public static void loadView(Screen screen) {
        printEnter();
        printTitle(screen.getTitle());
        printFunctionList(screen.getFunctionList());
    }

    private static void printTitle(String title) {
        System.out.println(SHARP_HEADER + title);
    }

    private static void printFunctionList(List<String> functionList) {
        for (String function : functionList) {
            System.out.println(function);
        }
    }

    private static void printEnter() {
        System.out.println();
    }
}
