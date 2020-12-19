package subway.station.validation;

import subway.station.Station;

public class SameStartEndStation {
    private static final String SAME_START_END_STATION = "[ERROR] 출발역과 도착역이 동일합니다.";

    public static void validate(Station startStation, Station endStation) {
        if (startStation.isSameName(endStation)) {
            throw new IllegalArgumentException(SAME_START_END_STATION);
        }
    }
}
