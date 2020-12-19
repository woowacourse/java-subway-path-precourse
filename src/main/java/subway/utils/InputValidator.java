package subway.utils;

public class InputValidator {

    private static final String QUIT_CODE = "Q";
    private static final String BACK_CODE = "B";
    private static final String ONE = "1";
    private static final String TWO = "2";
    private static final String MAIN_OPTION_ERROR = "1 또는 Q를 입력하세요";
    private static final String PATH_OPTION_ERROR = "1, 2 또는 B를 입력하세요";

    public static void validateMainUserOption(String userOption) {
        if (userOption.equals(QUIT_CODE)) {
            return;
        }
        if (userOption.equals(ONE)) {
            return;
        }
        throw new IllegalArgumentException(MAIN_OPTION_ERROR);
    }

    public static void validatePathUserOption(String userOption) {
        if (userOption.equals(BACK_CODE)) {
            return;
        }
        if (userOption.equals(ONE) || userOption.equals(TWO)) {
            return;
        }
        throw new IllegalArgumentException(PATH_OPTION_ERROR);
    }
}
