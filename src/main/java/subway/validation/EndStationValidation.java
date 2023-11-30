package subway.validation;

import static subway.exception.ErrorInputException.ErrorMessage.END_STATION_CANNOT_BE_NULL_OR_EMPTY;
import static subway.exception.ErrorInputException.ErrorMessage.IS_NOT_REGISTERED;
import static subway.exception.ErrorInputException.ErrorMessage.START_AND_END_ARE_DUPLICATE;

import java.util.Arrays;
import subway.domain.StationInfo;
import subway.exception.ErrorInputException;

public class EndStationValidation {
    public static void isBlank(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new ErrorInputException(END_STATION_CANNOT_BE_NULL_OR_EMPTY);
        }
    }

    public void isRegister(String input) {
        boolean isRegistered = Arrays.stream(StationInfo.values())
                .anyMatch(stationInfo -> stationInfo.getName().equals(input));
        if (!isRegistered) {
            throw new ErrorInputException(IS_NOT_REGISTERED);
        }
    }

    public String isDuplicate(String start, String end) {
        if (start.equals(end)) {
            throw new ErrorInputException(START_AND_END_ARE_DUPLICATE);
        }
        return end;
    }
}
