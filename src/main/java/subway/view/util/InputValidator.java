package subway.view.util;

import subway.controller.ScreenController;
import subway.view.OutputView;
import subway.view.resource.ErrorCode;
import subway.view.resource.Screen;

import java.util.Scanner;

public class InputValidator {
    private InputValidator() {
    }

    public static String validateFunctionCode(Scanner scanner, String functionCode, Screen screen) {
        if (isInvalidFunctionCode(functionCode, screen)) {
            OutputView.printError(ErrorCode.INVALID_FUNCTION);
            ScreenController.run(screen, scanner);
        }
        return functionCode;
    }

    private static boolean isInvalidFunctionCode(String functionCode, Screen screen) {
        if (!screen.getFunctionCodeList().contains(functionCode)) {
            return true;
        }
        return false;
    }

}
