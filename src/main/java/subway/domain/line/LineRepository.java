package subway.domain.line;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.section.Section;
import subway.domain.station.Station;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    static {
        lines.add(new Line("2호선",
            new ArrayList<Station>(Arrays.asList(
                new Station("교대역"),
                new Station("강남역"),
                new Station("역삼역"))
            ),
            new ArrayList<Section>(Arrays.asList(
                new Section(2, 3),
                new Section(2, 3))
            )));
        lines.add(new Line("3호선",
            new ArrayList<Station>(Arrays.asList(
                new Station("교대역"),
                new Station("남부터미널역"),
                new Station("양재역"),
                new Station("매봉역"))
            ),
            new ArrayList<Section>(Arrays.asList(
                new Section(3, 2),
                new Section(6, 5),
                new Section(1, 1))
            )));
        lines.add(new Line("신분당선",
            new ArrayList<Station>(Arrays.asList(
                new Station("강남역"),
                new Station("양재역"),
                new Station("양재시민의숲역"))
            ),
            new ArrayList<Section>(Arrays.asList(
                new Section(2, 8),
                new Section(10, 3))
            )));
    }

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void deleteAll() {
        lines.clear();
    }

    public static List<String> getShortestPath(String startStationName, String endStationName) {
        WeightedMultigraph<String, DefaultWeightedEdge> graph
            = new WeightedMultigraph(DefaultWeightedEdge.class);
        for (Line line : lines) {
            List<Station> stations = line.getStations();
            for (Station station : stations) {
                graph.addVertex(station.getName());
            }
            List<Section> sections = line.getSections();
            for (int i = 0; i < sections.size(); i++) {
                String sourceStationName = stations.get(i).getName();
                String tartgetStationName = stations.get(i + 1).getName();
                int distance = sections.get(i).getDistance();
                graph.setEdgeWeight(graph.addEdge(sourceStationName, tartgetStationName), distance);
            }
        }
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        return dijkstraShortestPath.getPath(startStationName, endStationName).getVertexList();
    }

    public static List<String> getShortestTimePath(String startStationName, String endStationName) {
        WeightedMultigraph<String, DefaultWeightedEdge> graph
            = new WeightedMultigraph(DefaultWeightedEdge.class);
        for (Line line : lines) {
            List<Station> stations = line.getStations();
            for (Station station : stations) {
                graph.addVertex(station.getName());
            }
            List<Section> sections = line.getSections();
            for (int i = 0; i < sections.size(); i++) {
                String sourceStationName = stations.get(i).getName();
                String tartgetStationName = stations.get(i + 1).getName();
                int time = sections.get(i).getTime();
                graph.setEdgeWeight(graph.addEdge(sourceStationName, tartgetStationName), time);
            }
        }
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        return dijkstraShortestPath.getPath(startStationName, endStationName).getVertexList();
    }
}
