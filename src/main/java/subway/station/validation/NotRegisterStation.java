package subway.station.validation;

import subway.station.Station;

public class NotRegisterStation {
    private static final String NOT_REGISTER_STATION = "[ERROR] 등록되지 않은 역입니다.";

    public static void validate(Station station) {
        if (station == null) {
            throw new IllegalArgumentException(NOT_REGISTER_STATION);
        }
    }
}
