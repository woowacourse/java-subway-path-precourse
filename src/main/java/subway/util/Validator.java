package subway.util;

import subway.view.OutputView;

import java.util.List;

public class Validator {

    public static void functionSelect(List<String> choices, String command) {
        if (!choices.contains(command)) {
            OutputView.printError(OutputView.ERROR_INVALID_SELECT);
            throw new IllegalArgumentException();
        }
    }

}
