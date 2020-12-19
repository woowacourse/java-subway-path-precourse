package subway.domain.validator;

import subway.domain.Station;
import subway.domain.exception.InvalidSearchingStationException;

public class SearchValidator {
    private SearchValidator() {
    }

    public static void checkTwoStationsAreDifferent(Station from, Station to) {
        if (from.equals(to)) {
            throw new InvalidSearchingStationException("출발역과 도착역은 동일할 수 없습니다.");
        }
    }
}
