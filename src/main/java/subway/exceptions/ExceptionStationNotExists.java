package subway.exceptions;

import static subway.SubwayKeyWords.ERROR_STATION_NOT_EXISTS;

public class ExceptionStationNotExists extends RuntimeException {

    public ExceptionStationNotExists() {
        super(ERROR_STATION_NOT_EXISTS);
    }

}
