package subway.domain;

import java.util.List;
import subway.message.ErrorMessage;

public class Section {

    public static final int MIN_STATIONS_SIZE = 2;
    public static final int MIN_GAPS_SIZE = 1;

    private final Line line;
    private final List<Station> stations;
    private final List<Gap> gaps;

    public Section(Line line, List<Station> stations, List<Gap> gaps)
        throws IllegalArgumentException {
        validateStationsSize(stations);
        validateGapsSize(gaps);
        validateDifferenceBetweenStationsSizeAndGapsSize(stations, gaps);
        this.line = line;
        this.stations = stations;
        this.gaps = gaps;
    }

    private void validateStationsSize(List<Station> stations) throws IllegalArgumentException {
        if (stations.size() < MIN_STATIONS_SIZE) {
            throw new IllegalArgumentException(
                ErrorMessage.SECTION_STATIONS_TOO_SMALL.toString()
            );
        }
    }

    private void validateGapsSize(List<Gap> gaps) throws IllegalArgumentException {
        if (gaps.size() < MIN_GAPS_SIZE) {
            throw new IllegalArgumentException(
                ErrorMessage.SECTION_GAPS_TOO_SMALL.toString()
            );
        }
    }

    private void validateDifferenceBetweenStationsSizeAndGapsSize(List<Station> stations,
        List<Gap> gaps) throws IllegalArgumentException {
        if (stations.size() != gaps.size() + 1) {
            throw new IllegalArgumentException(
                ErrorMessage.SECTION_GAPS_STATIONS_DIFFERENCE.toString()
            );
        }
    }

    private void validateStationIndex(final int index) throws IllegalArgumentException {
        if (index < 0 || index >= stations.size()) {
            throw new IllegalArgumentException(
                ErrorMessage.SECTION_STATION_INDEX_OUT_OF_RANGE.toString()
            );
        }
    }

    public Station getStationByIndex(final int index) throws IllegalArgumentException {
        validateStationIndex(index);
        return stations.get(index);
    }

    private void validateIndexesDifference(final int indexAhead, final int indexBehind)
        throws IllegalArgumentException {
        if (Integer.min(indexAhead, indexBehind) + 1 != Integer.max(indexAhead, indexBehind)) {
            throw new IllegalArgumentException(
                ErrorMessage.SECTION_STATION_INDEXES_DIFFERENCE.toString()
            );
        }
    }

    private void validateIndexesRange(final int indexAhead, final int indexBehind)
        throws IllegalArgumentException {
        if (Integer.min(indexAhead, indexBehind) < 0 ||
            Integer.max(indexAhead, indexBehind) >= stations.size()) {
            throw new IllegalArgumentException(
                ErrorMessage.SECTION_STATION_INDEX_OUT_OF_RANGE.toString()
            );
        }
    }

    public Gap getGapByTwoIndexes(final int indexAhead, final int indexBehind)
        throws IllegalArgumentException {
        validateIndexesDifference(indexAhead, indexBehind);
        validateIndexesRange(indexAhead, indexBehind);
        return gaps.get(Integer.min(indexAhead, indexBehind));
    }

    public Line getLine() {
        return line;
    }
}
