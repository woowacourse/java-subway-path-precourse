package subway.view.validator;

import static subway.util.message.ExceptionMessage.BLANK_MESSAGE;

public class Validator {
    protected static void validateBlank(final String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(BLANK_MESSAGE.getValue());
        }
    }
}
