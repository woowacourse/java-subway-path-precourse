package subway.domain.graph;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.line.Line;
import subway.domain.station.Station;

public class DistanceGraph {
    private Line line;
    private final WeightedMultigraph<Station, DefaultWeightedEdge> distanceGraph = new WeightedMultigraph<>(DefaultWeightedEdge.class);

    public DistanceGraph(Line line) {
        this.line = line;
    }

    public void updateGraph(Station station1, Station station2, int pathWeight) {
        if (!distanceGraph.containsVertex(station1))
            distanceGraph.addVertex(station1);
        if (!distanceGraph.containsVertex(station2))
            distanceGraph.addVertex(station2);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(station1, station2), pathWeight);
    }

    public boolean lineEquals(Line inputLine) {
        return line.equals(inputLine);
    }

}
