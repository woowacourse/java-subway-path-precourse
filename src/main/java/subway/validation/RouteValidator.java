package subway.validation;

import subway.domain.StationRepository;
import subway.message.CommonMessage;
import subway.message.RouteMessage;

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

    public static String validStationName(String stationName) {
        if (StationRepository.contains(stationName)) {
            return stationName;
        }
        throw new IllegalArgumentException(
            RouteMessage.ERROR_STATION_NAME.getMessage());
    }
}
