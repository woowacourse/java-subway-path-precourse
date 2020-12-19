package subway.validation;

import subway.message.CommonMessage;

public class RouteValidator {
    private static final String MAIN_FUNCTION_BOUNDARY_CHECK = "[12B]{1}";

    private static boolean isValidMenu(String menuNumber) {
        return menuNumber.matches(MAIN_FUNCTION_BOUNDARY_CHECK);
    }

    public static String validRouteMenu(String menuNumber) {
        if (isValidMenu(menuNumber)) {
            return menuNumber;
        }

        throw new IllegalArgumentException(
            CommonMessage.ERROR_SELECT_FUNCTION.getMessage());
    }
}
