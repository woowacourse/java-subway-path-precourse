package subway.domain.Path;

import org.jgrapht.graph.DefaultWeightedEdge;
import subway.domain.station.domain.Station;

public class PathRepository {

    private static final WeightGraph distanceWeightGraph = new WeightGraph();
    private static final WeightGraph timeWeightGraph = new WeightGraph();

    public static WeightGraph getDistanceWeightGraph() {
        return distanceWeightGraph;
    }

    public static WeightGraph getTimeWeightGraph() {
        return timeWeightGraph;
    }

    public static DefaultWeightedEdge addDistanceWeightEdge(Station sourceStation, Station targetStation, double weight) {
        return distanceWeightGraph.addEdge(sourceStation, targetStation, weight);
    }

    public static DefaultWeightedEdge addTimeWeightEdge(Station sourceStation, Station targetStation, double weight) {
        return timeWeightGraph.addEdge(sourceStation, targetStation, weight);
    }

    public static void addVertex(Station station) {
        distanceWeightGraph.addVertex(station);
        timeWeightGraph.addVertex(station);
    }
}
