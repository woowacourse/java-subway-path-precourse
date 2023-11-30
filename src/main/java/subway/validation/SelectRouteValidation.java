package subway.validation;

import static subway.exception.ErrorInputException.ErrorMessage.SELECT_ROUTE_CANNOT_BE_NULL_OR_EMPTY;
import static subway.exception.ErrorInputException.ErrorMessage.SELECT_ROUTE_MUST_BE_ONE_OR_OR_TWO_OR_B;

import subway.exception.ErrorInputException;

public class SelectRouteValidation {
    public static void isBlank(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new ErrorInputException(SELECT_ROUTE_CANNOT_BE_NULL_OR_EMPTY);
        }
    }

    public static String isOneOrTwoOrB(String input) {
        if (!input.equals("1") && !input.equals("2") && !input.equals("B")) {
            throw new ErrorInputException(SELECT_ROUTE_MUST_BE_ONE_OR_OR_TWO_OR_B);
        }
        return input;
    }
}
