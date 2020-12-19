package subway.utils;

public class StringUtils {

    private StringUtils() {
    }

    public static int toInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력하셔야 됩니다.");
        }
    }
}
