package subway.domain.line;

import subway.domain.station.Station;
import subway.exception.line.StationAlreadyInLineException;

import java.util.List;

public class LineStations {

    private final List<LineStation> lineStations;

    public LineStations(List<LineStation> lineStations) {
        this.lineStations = lineStations;
    }

    public boolean contains(Station targetStation) {
        for (LineStation lineStation : lineStations) {
            if (lineStation.getStation().equals(targetStation)) {
                return true;
            }
        }
        return false;
    }

    public void add(Station station) {
        LineStation newLineStation = LineStation.of(station);
        if (contains(newLineStation.getStation())) {
            throw new StationAlreadyInLineException(station.getName());
        }
        lineStations.add(newLineStation);
    }

    public void addRouteInfo(String info) {
        LineStation newRouteInfo = LineStation.ofRouteInfo(info);

        lineStations.add(newRouteInfo);
    }
}
