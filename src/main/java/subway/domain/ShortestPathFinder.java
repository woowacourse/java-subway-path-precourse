package subway.domain;

import subway.exception.SubwayException;

import java.util.Collections;
import java.util.List;

public class ShortestPathFinder {
    public static final String ERR_WRONG_TYPE_MSG = "해당 타입이 없습니다.";

    List<Station> stations;
    Sections sections;
    FindPathType findPathType;

    public ShortestPathFinder(List<Station> stations, Sections sections) {
        this.stations = stations;
        this.sections = sections;
    }

    public int calculateShortest(FindPathType type) {
        if (FindPathType.DISTANCE == type) {
            return 0;
        }
        if (FindPathType.DISTANCE == type) {
            return 0;
        }
        throw new SubwayException(ERR_WRONG_TYPE_MSG);
    }

    public List<Station> getStationsOnPath(){
        return Collections.emptyList();
    }
}
