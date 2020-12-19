package subway.view.utils;

import java.util.regex.Pattern;

public class InputValidator {
    private static String ERROR_INVALID_FUNCTION = "[ERROR] 선택할 수 없는 기능입니다.";
    private static String ERROR_EMPTY = "[ERROR] 아무것도 입력하지 않았습니다.";

    private InputValidator() {
    }

    public static void validatePattern(String pattern, String input) {
        if (!Pattern.matches(pattern, input)) {
            throw new IllegalArgumentException(ERROR_INVALID_FUNCTION);
        }
    }

    public static void validateEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY);
        }
    }
}
