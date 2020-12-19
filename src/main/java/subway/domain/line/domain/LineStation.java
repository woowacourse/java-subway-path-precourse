package subway.domain.line.domain;

import org.jgrapht.graph.DefaultWeightedEdge;
import subway.domain.Path.PathRepository;
import subway.domain.station.domain.Station;

public class LineStation {

    private final Station station;
    private Station prevStation;
    private DefaultWeightedEdge distanceWeightEdge;
    private DefaultWeightedEdge timeWeightEdge;

    public LineStation(Station station, Station prevStation,
        DefaultWeightedEdge distanceWeightEdge, DefaultWeightedEdge timeWeightEdge) {
        this.station = station;
        this.prevStation = prevStation;
        this.distanceWeightEdge = distanceWeightEdge;
        this.timeWeightEdge = timeWeightEdge;
    }

    public static LineStation from(Station station) {
        return new LineStation(station, null, null, null);
    }

    public static LineStation of(Station station, Station prevStation,
        DefaultWeightedEdge distanceWeightEdge, DefaultWeightedEdge timeWeightEdge) {
        return new LineStation(station, prevStation, distanceWeightEdge, timeWeightEdge);
    }

    public boolean isFirst() {
        return prevStation == null;
    }

    public String getName() {
        return station.getName();
    }

    public Station getStation() {
        return station;
    }

    public Station getPrevStation() {
        return prevStation;
    }

    public void setPrevStation(Station station) {
        prevStation = station;
    }

    public void getDistance(double distance) {
        PathRepository.getDistanceWeightGraph().getEdgeWeight(distanceWeightEdge);
    }

    public void setDistance(double distance) {
        PathRepository.getDistanceWeightGraph().setEdgeWeight(distanceWeightEdge, distance);
    }

    public void getTime(double time) {
        PathRepository.getTimeWeightGraph().getEdgeWeight(timeWeightEdge);
    }

    public void setTime(double time) {
        PathRepository.getTimeWeightGraph().setEdgeWeight(timeWeightEdge, time);
    }
}
