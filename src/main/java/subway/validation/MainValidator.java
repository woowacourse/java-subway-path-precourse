package subway.validation;

import subway.message.CommonMessage;
import subway.view.UserView;

public class MainValidator {
    private static final String MAIN_FUNCTION_BOUNDARY_CHECK = "[1Q]{1}";

    private static boolean isValidMenu(String menuNumber) {
        return menuNumber.matches(MAIN_FUNCTION_BOUNDARY_CHECK);
    }

    public static String validMainMenu(String menuNumber) {
        if (isValidMenu(menuNumber)) {
            return menuNumber;
        }

        throw new IllegalArgumentException(
            CommonMessage.ERROR_SELECT_FUNCTION.getMessage());
    }
}
