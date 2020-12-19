package subway.domain;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;

public class SubwayMap {
    private String lineName;
    private List<SubwayPath> subwayPaths;
    WeightedMultigraph<String, DefaultWeightedEdge> shortestPathGraph;
    WeightedMultigraph<String, DefaultWeightedEdge> minimumTimeGraph;

    public SubwayMap(String lineName, List<SubwayPath> subwayPaths) {
        this.lineName = lineName;
        this.subwayPaths = subwayPaths;
        makeShortestPathGraph();
        makeMinimumTimeGraph();
    }

    public String getLineName() {
        return lineName;
    }

    public List<SubwayPath> getPaths() {
        return subwayPaths;
    }

    public WeightedMultigraph<String, DefaultWeightedEdge> getShortestPathGraph() {
        return shortestPathGraph;
    }

    public WeightedMultigraph<String, DefaultWeightedEdge> getMinimumTimeGraph() {
        return minimumTimeGraph;
    }

    private void makeShortestPathGraph() {
        shortestPathGraph = new WeightedMultigraph(DefaultWeightedEdge.class);
        for (SubwayPath subwayPath : subwayPaths) {
            String departureStation = subwayPath.getDepartureStation();
            String arrivalStation = subwayPath.getArrivalStation();
            int distance = subwayPath.getDistance();
            shortestPathGraph.addVertex(departureStation);
            shortestPathGraph.addVertex(arrivalStation);
            shortestPathGraph.setEdgeWeight(shortestPathGraph.addEdge(departureStation, arrivalStation), distance);
        }
    }

    private void makeMinimumTimeGraph() {
        minimumTimeGraph = new WeightedMultigraph(DefaultWeightedEdge.class);
        for (SubwayPath subwayPath : subwayPaths) {
            String departureStation = subwayPath.getDepartureStation();
            String arrivalStation = subwayPath.getArrivalStation();
            int time = subwayPath.getTime();
            shortestPathGraph.addVertex(departureStation);
            shortestPathGraph.addVertex(arrivalStation);
            shortestPathGraph.setEdgeWeight(shortestPathGraph.addEdge(departureStation, arrivalStation), time);
        }
    }

//        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
//        List<String> shortestPath = dijkstraShortestPath.getPath("v3", "v1").getVertexList();


}
