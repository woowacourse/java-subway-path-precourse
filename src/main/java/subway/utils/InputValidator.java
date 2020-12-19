package subway.utils;

import subway.utils.exception.InvalidMenuInputException;

import java.util.regex.Pattern;

public class InputValidator
{
    private static String MENU_PATTERN = "^[0-9]|Q|B$";

    public void invalidMenu(String menu) {
        if (!Pattern.matches(MENU_PATTERN, menu)) {
            throw new InvalidMenuInputException();
        }
    }
}
