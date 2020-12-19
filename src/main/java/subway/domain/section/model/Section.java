package subway.domain.section.model;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.station.model.Station;

public class Section {
    private final Station startStation;
    private final Station arrivalStation;
    private final RunTime runTime;
    private final Distance distance;

    public Section(Station startStation, Station arrivalStation, RunTime runTime, Distance distance) {
        this.startStation = startStation;
        this.arrivalStation = arrivalStation;
        this.runTime = runTime;
        this.distance = distance;
    }

    public Section(Station startStation, Station arrivalStation, int runTime, int distance) {
        this(startStation, arrivalStation, new RunTime(runTime), new Distance(distance));
    }

    public Section(String startStation, String arrivalStation, int runTime, int distance) {
        this(new Station(startStation), new Station(arrivalStation)
                , new RunTime(runTime), new Distance(distance));
    }

    public void updateDistanceGraph(WeightedMultigraph<Station, DefaultWeightedEdge> graph) {
        graph.addVertex(startStation);
        graph.addVertex(arrivalStation);
        graph.setEdgeWeight(graph.addEdge(startStation, arrivalStation), distance.getValue());
    }

    public void updateRunTimeGraph(WeightedMultigraph<Station, DefaultWeightedEdge> graph) {
        graph.addVertex(startStation);
        graph.addVertex(arrivalStation);
        graph.setEdgeWeight(graph.addEdge(startStation, arrivalStation), runTime.getValue());
    }

    public boolean isEqualTo(Station startStation, Station arrivalStation) {
        return this.startStation.equals(startStation) && this.arrivalStation.equals(arrivalStation);
    }

    public int getDistance() {
        return distance.getValue();
    }

    public int getRunTime() {
        return runTime.getValue();
    }
}
