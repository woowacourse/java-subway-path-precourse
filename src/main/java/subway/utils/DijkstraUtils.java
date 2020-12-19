package subway.utils;

import java.util.List;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.RouteResultDTO;
import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class DijkstraUtils {

    private static WeightedMultigraph<String, DefaultWeightedEdge> graph;

    private DijkstraUtils() {
    }

    public static RouteResultDTO retrieveByDistance(Station sourceName, Station targetName) {
        initGraph();
        addVertices();
        addEdgesDistance();
        GraphPath<String, DefaultWeightedEdge> graphPath = getPath(sourceName.getName(),
                targetName.getName());
        return new RouteResultDTO(
                graphPath.getVertexList(),
                graphPath.getWeight(),
                getTime(graphPath.getVertexList()));
    }

    public static RouteResultDTO retrieveByTime(Station sourceStation, Station targetStation) {
        initGraph();
        addVertices();
        addEdgesTime();
        GraphPath<String, DefaultWeightedEdge> graphPath = getPath(sourceStation.getName(),
                targetStation.getName());
        return new RouteResultDTO(
                graphPath.getVertexList(),
                getDistance(graphPath.getVertexList()),
                graphPath.getWeight());
    }

    private static Double getTime(List<String> vertexList) {
        //todo vertexList 따라가면서 timeWeight 더하기
        return 1.0;
    }

    private static Double getDistance(List<String> vertexList) {
        //todo vertexList 따라가면서 distanceWeight 더하기
        return 1.0;
    }

    private static GraphPath<String, DefaultWeightedEdge> getPath(String sourceName,
            String targetName) {
        //  todo 경로 조회 시 출발역과 도착역이 연결되어 있지 않으면 에러를 출력한다.

        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstraShortestPath = new DijkstraShortestPath(
                graph);
        return dijkstraShortestPath.getPath(sourceName, targetName);
    }

    private static void addEdgesDistance() {
        SectionRepository.sections().forEach(section -> graph.setEdgeWeight(
                graph.addEdge(
                        section.getSource().getName(),
                        section.getTarget().getName()),
                section.getDistanceWeight()));
    }

    private static void addEdgesTime() {
        SectionRepository.sections().forEach(section -> graph.setEdgeWeight(
                graph.addEdge(
                        section.getSource().getName(),
                        section.getTarget().getName()),
                section.getTimeWeight()));
    }

    private static void initGraph() {
        graph = new WeightedMultigraph(DefaultWeightedEdge.class);
    }

    private static void addVertices() {
        StationRepository.stations().forEach(station -> graph.addVertex(station.getName()));
    }
}
