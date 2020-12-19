package subway.mainscreen;

import java.util.regex.Pattern;
import subway.common.CommonPrinter;

public class MainScreenErrorChecker {
    private static final String MAIN_SELECTION_PATTERN = "[1Q]";


    public static void validateMainUserSelectionInput(String userSelectionInput)
        throws IllegalArgumentException {
        if (!Pattern.matches(MAIN_SELECTION_PATTERN, userSelectionInput)) {
            CommonPrinter.printUserSelectionInputErrorMessage();
            throw new IllegalArgumentException();
        }
    }
}
