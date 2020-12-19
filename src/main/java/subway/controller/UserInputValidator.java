package subway.controller;

public class UserInputValidator {
    private static final String MAIN_SCREEN_FUNCTION_PATTERN = "^[1Q]$";

    public static boolean isValidMainScreenFunction(String input) {
        return input.matches(MAIN_SCREEN_FUNCTION_PATTERN);
    }
}
