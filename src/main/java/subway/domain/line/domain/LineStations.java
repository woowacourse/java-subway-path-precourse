package subway.domain.line.domain;

import java.util.ArrayList;
import java.util.List;
import org.jgrapht.graph.DefaultWeightedEdge;
import subway.domain.Path.domain.PathRepository;
import subway.domain.station.domain.Station;

public class LineStations {

    private final List<LineStation> lineStations;

    private LineStations(List<LineStation> lineStations) {
        this.lineStations = lineStations;
    }

    public static LineStations from() {
        return new LineStations(new ArrayList<>());
    }

    public static LineStations of(List<LineStation> lineStations) {
        return new LineStations(lineStations);
    }

    public static LineStations of(Station upstreamStation, Station downstreamStation,
        double distance, double time) {
        LineStations lineStations = from();
        lineStations.addFirstStation(upstreamStation);
        lineStations.add(downstreamStation, distance, time);

        return lineStations;
    }

    public boolean contains(Station targetStation) {
        for (LineStation lineStation : lineStations) {
            if (lineStation.getStation().equals(targetStation)) {
                return true;
            }
        }

        return false;
    }

    public int size() {
        return lineStations.size();
    }

    public void addFirstStation(Station station) {
        PathRepository.addVertex(station);
        lineStations.add(LineStation.from(station));
    }

    public void add(Station station, double distance, double time) {
        Station lastDownstreamStation = getLastDownstreamStation();
        DefaultWeightedEdge distanceWeightEdge = PathRepository
            .addDistanceWeightEdge(lastDownstreamStation, station, time);
        DefaultWeightedEdge timeWeightEdge = PathRepository
            .addTimeWeightEdge(lastDownstreamStation, station, distance);
        LineStation newLineStation = LineStation
            .of(station, lastDownstreamStation, distanceWeightEdge, timeWeightEdge);
        lineStations.add(newLineStation);
    }

    public List<LineStation> getLineStations() {
        return lineStations;
    }

    public Station getLastDownstreamStation() {
        return lineStations.get(lineStations.size() - 1).getStation();
    }
}
