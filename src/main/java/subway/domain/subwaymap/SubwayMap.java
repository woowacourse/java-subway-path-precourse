package subway.domain.subwaymap;

import java.util.List;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Station.Station;

public class SubwayMap {

    private String name;
    private WeightedMultigraph<Station, DefaultWeightedEdge> distanceBasedSubwayMap = new WeightedMultigraph(
        DefaultWeightedEdge.class);
    private WeightedMultigraph<Station, DefaultWeightedEdge> timeBasedSubwayMap = new WeightedMultigraph(
        DefaultWeightedEdge.class);

    public SubwayMap(String name,
        WeightedMultigraph<Station, DefaultWeightedEdge> distanceBasedSubwayMap,
        WeightedMultigraph<Station, DefaultWeightedEdge> timeBasedSubwayMap) {
        this.name = name;
        this.distanceBasedSubwayMap = distanceBasedSubwayMap;
        this.timeBasedSubwayMap = timeBasedSubwayMap;
    }

    public List<Station> findShortestPathListByDistance(Station departureStation,
        Station arrivalStation) {

        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(
            distanceBasedSubwayMap);

        List<Station> shortestPath = dijkstraShortestPath.getPath(departureStation, arrivalStation)
            .getVertexList();
        return shortestPath;
    }

    public double findShortestPathDistance(Station departureStation,
        Station arrivalStation) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(
            distanceBasedSubwayMap);
        double shortestPath = dijkstraShortestPath.getPath(departureStation, arrivalStation)
            .getWeight();
        return shortestPath;
    }

    public double findStationPathTravelTime(List<Station> stations) {
        double time = 0;
        for (int i = 0; i < stations.size() - 1; i++) {
            DefaultWeightedEdge edge = timeBasedSubwayMap
                .getEdge(stations.get(i), stations.get(i + 1));
            time += timeBasedSubwayMap.getEdgeWeight(edge);
        }
        return time;
    }
}
