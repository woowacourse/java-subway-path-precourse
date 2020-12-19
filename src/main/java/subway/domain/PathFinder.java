package subway.domain;

import java.util.List;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.utils.DataInitialization;

public class PathFinder {
    private static WeightedMultigraph<Station, DefaultWeightedEdge> graphByDistance = DataInitialization.graphByDistance;
    private static WeightedMultigraph<Station, DefaultWeightedEdge> graphByTime = DataInitialization.graphByTime;


    public static GraphPath findPathBetweenStationsByShortestDistance(Station stationA, Station stationB) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graphByDistance);
        GraphPath shortestPath = dijkstraShortestPath.getPath(stationA, stationB);
        return shortestPath;
    }


    public static GraphPath findPathBetweenStationsByMinimumTime(Station stationA, Station stationB) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graphByTime);
        GraphPath shortestPath = dijkstraShortestPath.getPath(stationA, stationB);
        return shortestPath;
    }

}
