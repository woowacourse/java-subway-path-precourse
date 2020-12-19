package subway.domain;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.exception.SubwayException;

import java.util.List;
import java.util.Objects;

public class ShortestPathFinder {
    private static final String ERR_WRONG_TYPE_MSG = "해당 타입이 없습니다.";
    private static final String ERR_NOT_FONND_PATH_MSG = "출발역부터 도착역까지 갈 수 있는 경로가 없습니다.";
    private static final String ERR_CANT_SAME_STATION_MSG = "출발역과 도착역이 같을 수 없습니다.";

    private List<Station> stations;
    private Sections sections;
    private WeightedMultigraph<Station, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);
    private DijkstraShortestPath dijkstraShortestPath;

    public ShortestPathFinder(List<Station> stations, Sections sections) {
        this.stations = stations;
        this.sections = sections;
        graphVertexAndEdgeSetting();
    }

    public void setType(FindPathType type) {
        graphEdgeWeightSetting(type);
        computeShortestPath();
    }

    private void computeShortestPath() {
        dijkstraShortestPath = new DijkstraShortestPath(graph);
    }

    public int calculateShortestStationNumber(Station from, Station to) {
        return getStationsOnPath(from, to).size();
    }

    public List<Station> getStationsOnPath(Station from, Station to) {
        isSame(from, to);
        GraphPath path = dijkstraShortestPath.getPath(from, to);
        validatePath(path);
        return path.getVertexList();
    }

    private void validatePath(GraphPath path) {
        if (Objects.isNull(path)) {
            throw new SubwayException(ERR_NOT_FONND_PATH_MSG);
        }
    }

    private void isSame(Station from, Station to) {
        if (from.equals(to)) {
            throw new SubwayException(ERR_CANT_SAME_STATION_MSG);
        }
    }

    private void graphVertexAndEdgeSetting() {
        addVertex();
        addEdge();
    }

    private void addVertex() {
        for (Station station : stations) {
            graph.addVertex(station);
        }
    }

    private void addEdge() {
        for (Section section : sections.getUnmodifiableList()) {
            graph.addEdge(section.from(), section.to());
        }
    }

    private void graphEdgeWeightSetting(FindPathType type) {
        if (FindPathType.DISTANCE == type) {
            edgeWeightSettingForDistance(sections);
            return;
        }
        if (FindPathType.TIME == type) {
            edgeWeightSettingForTime(sections);
            return;
        }
        throw new SubwayException(ERR_WRONG_TYPE_MSG);
    }

    private void edgeWeightSettingForDistance(Sections sections) {
        for (Section section : sections.getUnmodifiableList()) {
            graph.setEdgeWeight(graph.getEdge(section.from(), section.to()), section.getDistance());
        }
    }

    private void edgeWeightSettingForTime(Sections sections) {
        for (Section section : sections.getUnmodifiableList()) {
            graph.setEdgeWeight(graph.getEdge(section.from(), section.to()), section.getTakenTime());
        }
    }
}
