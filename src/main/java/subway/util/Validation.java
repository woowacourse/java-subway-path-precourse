package subway.util;

import java.util.regex.Pattern;

public final class Validation {
    private Validation() {
    }

    public static boolean isNumeric(String str) {
        return str != null && !str.isEmpty() && Pattern.matches("^[0-9]*$", str);
    }
}
