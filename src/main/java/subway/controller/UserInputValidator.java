package subway.controller;

public class UserInputValidator {
    private static final String MAIN_SCREEN_FUNCTION_PATTERN = "^[1Q]$";
    private static final String PATH_SEARCH_SCREEN_FUNCTION_PATTERN = "^[12B]$";

    public static boolean isValidMainScreenFunction(String input) {
        return input.matches(MAIN_SCREEN_FUNCTION_PATTERN);
    }

    public static boolean isValidPathSearchScreenFunction(String input) {
        return input.matches(PATH_SEARCH_SCREEN_FUNCTION_PATTERN);
    }
}
