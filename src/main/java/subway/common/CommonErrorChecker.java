package subway.common;

import java.util.regex.Pattern;

public class CommonErrorChecker {
    public static final String MAIN_SELECTION_PATTERN = "[1Q]";
    public static final String FIND_WAY_SELECTION_PATTERN = "[12B]";


    public static void validateMenuSelectionInput(String userSelectionInput, String pattern)
        throws IllegalArgumentException {
        if (!Pattern.matches(pattern, userSelectionInput)) {
            CommonPrinter.printUserSelectionInputErrorMessage();
            throw new IllegalArgumentException();
        }
    }
}
