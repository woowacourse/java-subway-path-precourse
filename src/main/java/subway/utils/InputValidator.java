package subway.utils;

public class InputValidator {

    private static final String QUIT_CODE = "Q";
    private static final String ONE = "1";
    private static final String MAIN_OPTION_ERROR = "1 또는 Q를 입력하세요";

    public static void validateMainUserOption(String userOption) {
        if (userOption.equals(QUIT_CODE)) {
            return;
        }
        if (userOption.equals(ONE)) {
            return;
        }
        throw new IllegalArgumentException(MAIN_OPTION_ERROR);
    }
}
