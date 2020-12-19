package subway.domain;

import org.jgrapht.graph.DefaultWeightedEdge;

public class Section extends DefaultWeightedEdge {
    private Station startStation;
    private Station endStation;
    private int time;
    private int distance;

    public Section(Station startStation, Station endStation, int time, int distance) {
        this.startStation = startStation;
        this.endStation = endStation;
        this.time = time;
        this.distance = distance;
    }

    public int getTime() {
        return time;
    }

    public int getDistance() {
        return distance;
    }

    public static Section of(Station start, Station end, int time, int distance) {
        return new Section(start, end, time, distance);
    }
}