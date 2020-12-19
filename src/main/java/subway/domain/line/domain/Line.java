package subway.domain.line.domain;

import java.util.List;
import java.util.Objects;
import subway.domain.line.exception.DuplicateStationNameInLineException;
import subway.domain.line.exception.ShorterThanMinLineNameException;
import subway.domain.line.exception.UpstreamDownstreamStationInputException;
import subway.domain.station.domain.Station;

public class Line {

    public static final int MIN_NAME_SIZE = 2;

    private final String name;
    private final LineStations lineStations;

    private Line(String name, LineStations lineStations) {
        this.name = name;
        this.lineStations = lineStations;
    }

    public static Line of(String name, Station upstreamStation, Station downstreamStation,
        double distance, double time) {
        checkAddLineValidation(name, upstreamStation, downstreamStation);
        LineStations lineStations = LineStations.of(upstreamStation, downstreamStation, distance, time);

        return new Line(name, lineStations);
    }

    private static void checkAddLineValidation(String name, Station upstreamStation,
        Station downstreamStation) {
        if (name.length() < MIN_NAME_SIZE) {
            throw new ShorterThanMinLineNameException(name);
        }

        if (upstreamStation.equals(downstreamStation)) {
            throw new UpstreamDownstreamStationInputException(upstreamStation.getName(),
                downstreamStation.getName());
        }
    }

    public boolean contains(Station target) {
        return lineStations.contains(target);
    }

    public void addSection(Station station, double distance, double time) {
        if (lineStations.contains(station)) {
            throw new DuplicateStationNameInLineException(name, station.getName());
        }

        lineStations.add(station, distance, time);
    }

    public String getName() {
        return name;
    }

    public List<LineStation> getLineStations() {
        return lineStations.getLineStations();
    }

    public Station getLastDownstreamStation() {
        return lineStations.getLastDownstreamStation();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Line line = (Line) o;
        return Objects.equals(name, line.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
