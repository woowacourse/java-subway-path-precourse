package subway.exceptions;

import static subway.SubwayKeyWords.ERROR_STATION_SAME_NAME;

public class ExceptionSameStationSubmitted extends RuntimeException {

    public ExceptionSameStationSubmitted() {
        super(ERROR_STATION_SAME_NAME);
    }
}
