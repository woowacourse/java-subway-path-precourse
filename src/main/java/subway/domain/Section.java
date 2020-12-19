package subway.domain;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class Section {
    private final Station departureStation;
    private final Station arrivalStation;
    private final int distance;
    private final int time;

    public Section(Station departureStation, Station arrivalStation, int distance, int time) {
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.distance = distance;
        this.time = time;
    }

    public Station getDepartureStation() {
        return this.departureStation;
    }

    public Station getArrivalStation() {
        return this.arrivalStation;
    }

    public int getDistance() {
        return this.distance;
    }

    public int getTime() {
        return this.time;
    }
}
