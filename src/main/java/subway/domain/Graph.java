package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;

public class Graph {
    private WeightedMultigraph<Station, DefaultWeightedEdge> minimumPhysicalDistanceGraph
            = new WeightedMultigraph(DefaultWeightedEdge.class);
    private WeightedMultigraph<Station, DefaultWeightedEdge> minimumTimeDistanceGraph
            = new WeightedMultigraph(DefaultWeightedEdge.class);

    public void addNoteWithDistance(Distance distance) {
        minimumPhysicalDistanceGraph.addVertex(distance.getStation1());
        minimumPhysicalDistanceGraph.addVertex(distance.getStation2());
        minimumTimeDistanceGraph.addVertex(distance.getStation1());
        minimumTimeDistanceGraph.addVertex(distance.getStation2());
        minimumPhysicalDistanceGraph.setEdgeWeight(minimumPhysicalDistanceGraph
                .addEdge(distance.getStation1(), distance.getStation2()), distance.getPhysicalDistance());
        minimumTimeDistanceGraph.setEdgeWeight(minimumTimeDistanceGraph
                .addEdge(distance.getStation1(), distance.getStation2()), distance.getTimeDistance());
    }

    public List<Station>  getMinimumPhysicalDistanceBetweenStations(Station stationBegin, Station stationEnd) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(minimumPhysicalDistanceGraph);
        return dijkstraShortestPath.getPath(stationBegin, stationEnd).getVertexList();
    }

    public List<Station> getMinimumTimeDistanceBetweenStations(Station stationBegin, Station stationEnd) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(minimumTimeDistanceGraph);
        return dijkstraShortestPath.getPath(stationBegin, stationEnd).getVertexList();
    }
}
