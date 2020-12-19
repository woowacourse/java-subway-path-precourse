package subway.domain;

import subway.view.ErrorMessage;

import java.util.List;

public class Errors {
    public static boolean checkInput(String input, List<String> functions) {
        boolean check = true;
        if (!functions.contains(input)) {
            ErrorMessage.displayErrorMessage(Constants.FUNCTION_INPUT_ERROR);
            check = false;
        }
        return check;
    }
}
