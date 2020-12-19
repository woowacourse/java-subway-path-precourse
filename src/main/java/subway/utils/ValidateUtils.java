package subway.utils;

import subway.domain.StationRepository;
import subway.exception.SubwayException;

public class ValidateUtils {
    public static final String INVALID_STATION_EXCEPTION_MESSAGE = "존재하지 않는 역입니다.";
    public static final String EMPTY_VALUE_EXCEPTION_MESSAGE = "빈 값입니다.";
    public static final String SAME_STATION_NAME_EXCEPTION_MESSAGE = "출발역과 도착역이 동일합니다.";

    public static String isNotEmpty(String input) {
        if (input.trim().length() > 0){
            return input;
        }
        throw new SubwayException(EMPTY_VALUE_EXCEPTION_MESSAGE);
    }

    public static void isSame(String input, String anotherInput){
        if(input.equals(anotherInput)){
            throw new SubwayException(SAME_STATION_NAME_EXCEPTION_MESSAGE);
        }
    }

    public static String isValidStation(String input) {
        if (StationRepository.hasStation(input)) {
            return input;
        }
        throw new SubwayException(INVALID_STATION_EXCEPTION_MESSAGE);
    }
}
