package subway.domain.path;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.entity.Section;
import subway.domain.entity.Station;

public class SubwayMapGraph {

    private final WeightedMultigraph<Station, DefaultWeightedEdge> shortestDistanceGraph;
    private final WeightedMultigraph<Station, DefaultWeightedEdge> minimumTimeGraph;

    public SubwayMapGraph(WeightedMultigraph<Station, DefaultWeightedEdge> shortestDistanceGraph,
                          WeightedMultigraph<Station, DefaultWeightedEdge> minimumTimeGraph) {
        this.shortestDistanceGraph = shortestDistanceGraph;
        this.minimumTimeGraph = minimumTimeGraph;
    }

    public void addStationToGraph(Station firstStation, Station lastStation, Section section) {
        int distance = section.getDistance();
        int time = section.getTime();
        addShortestDistanceGraph(firstStation, lastStation, distance);
        addMinimumDistanceGraph(firstStation, lastStation, time);
    }

    private void addShortestDistanceGraph(Station firstStation, Station lastStation, int distance) {
        shortestDistanceGraph.addVertex(firstStation);
        shortestDistanceGraph.addVertex(lastStation);
        shortestDistanceGraph.setEdgeWeight(shortestDistanceGraph.addEdge(firstStation, lastStation), distance);
    }

    private void addMinimumDistanceGraph(Station firstStation, Station lastStation, int time) {
        minimumTimeGraph.addVertex(firstStation);
        minimumTimeGraph.addVertex(lastStation);
        minimumTimeGraph.setEdgeWeight(minimumTimeGraph.addEdge(firstStation, lastStation), time);
    }
}
