package subway.validation;

import static subway.exception.ErrorInputException.ErrorMessage.MAIN_FUNCTION_CANNOT_BE_NULL_OR_EMPTY;
import static subway.exception.ErrorInputException.ErrorMessage.MAIN_FUNCTION_MUST_BE_ONE_OR_Q;

import subway.exception.ErrorInputException;

public class MainFunctionValidation {
    public static void isBlank(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new ErrorInputException(MAIN_FUNCTION_CANNOT_BE_NULL_OR_EMPTY);
        }
    }

    public static String isOneOrQ(String input) {
        if (!input.equals("1") && !input.equals("Q")) {
            throw new ErrorInputException(MAIN_FUNCTION_MUST_BE_ONE_OR_Q);
        }
        return input;
    }
}
