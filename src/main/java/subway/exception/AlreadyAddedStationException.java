package subway.exception;

import subway.domain.station.Station;

public class AlreadyAddedStationException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "[ERROR] 해당 역은 이미 추가되었습니다.";

    public AlreadyAddedStationException(Station station) {
        super(String.format(ERROR_MESSAGE, station.toString()));
    }
}
