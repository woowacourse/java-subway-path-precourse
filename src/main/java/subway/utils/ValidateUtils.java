package subway.utils;

public class ValidateUtils {
    public static boolean isValidMenuSelect(String selectMenu, int bound, char quit) {
        if (selectMenu.length() > 1) {
            return false;
        }
        char selectChar = selectMenu.charAt(0);
        if (selectChar == quit || (selectChar >= '1' && selectChar <= bound + '0')) {
            return true;
        }
        return false;
    }
}
