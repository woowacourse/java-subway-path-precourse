package subway.validation;

import static subway.exception.ErrorInputException.ErrorMessage.IS_NOT_REGISTERED;
import static subway.exception.ErrorInputException.ErrorMessage.START_STATION_CANNOT_BE_NULL_OR_EMPTY;

import java.util.Arrays;
import subway.domain.StationInfo;
import subway.exception.ErrorInputException;

public class StartStationValidation {
    public static void isBlank(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new ErrorInputException(START_STATION_CANNOT_BE_NULL_OR_EMPTY);
        }
    }

    public String isRegister(String input) {
        boolean isRegistered = Arrays.stream(StationInfo.values())
                .anyMatch(stationInfo -> stationInfo.getName().equals(input));
        if (!isRegistered) {
            throw new ErrorInputException(IS_NOT_REGISTERED);
        }
        return input;
    }
}
