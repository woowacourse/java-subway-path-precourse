package subway.view;

import subway.view.constants.PathInputOption;
import subway.view.constants.ViewConstant;

public class PathInputView {
    public static final String DEPATURE_MESSAGE = "출발역을 입력하세요.";
    public static final String TERMINAL_MESSAGE = "도착역을 입력하세요.";

    public static void askPathScreen() {
        for (PathInputOption option : PathInputOption.values()) {
            System.out.println(option.getMessage());
        }
    }

    public static void askDeparture() {
        System.out.printf(ViewConstant.SHARP, DEPATURE_MESSAGE);
    }

    public static void askTerminal() {
        System.out.printf(ViewConstant.SHARP, TERMINAL_MESSAGE);
    }
}
