package subway.domain;

import jdk.internal.util.xml.impl.Input;
import subway.view.InputView;

import java.util.Scanner;

public class PathSelectMenu {
    private static boolean isPathMenuRunFlag = true;

    private static void pathMenuStop() {
        isPathMenuRunFlag = false;
    }

    public static boolean isPathMenuRun() {
        return isPathMenuRunFlag;
    }

    public static void pathMenuRun(Scanner scanner) {
        isPathMenuRunFlag = true;
        while (isPathMenuRun()) {
            InputView.printPathMenuInput();
        }
    }
}
