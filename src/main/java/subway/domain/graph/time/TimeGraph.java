package subway.domain.graph.time;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.line.Line;
import subway.domain.station.Station;

public class TimeGraph {
    private Line line;
    private final WeightedMultigraph<Station, DefaultWeightedEdge> timeGraph = new WeightedMultigraph<>(DefaultWeightedEdge.class);

    public TimeGraph(Line line) {
        this.line = line;
    }

    public void updateGraph(Station station1, Station station2, int pathWeight) {
        if (!timeGraph.containsVertex(station1))
            timeGraph.addVertex(station1);
        if (!timeGraph.containsVertex(station2))
            timeGraph.addVertex(station2);
        timeGraph.setEdgeWeight(timeGraph.addEdge(station1, station2), pathWeight);
    }

    public boolean lineEquals(Line inputLine) {
        return line.equals(inputLine);
    }

}
