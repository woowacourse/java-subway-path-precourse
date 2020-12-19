package subway.domain;

import subway.error.SubwayErrorMessage;
import subway.error.SubwayException;

public class StationBetween {
    private final Station start;
    private final Station end;

    public StationBetween(String start, String end) {
        validateDuplicate(start, end);
        this.start = new Station(start);
        this.end = new Station(end);
    }

    private void validateDuplicate(String start, String end) {
        if (start.equals(end)) {
            throw new SubwayException(SubwayErrorMessage.DUPLICATE_NAME);
        }
    }

    public Station getStart() {
        return start;
    }

    public Station getEnd() {
        return end;
    }
}
