package subway.domain;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.exception.NoConnectionPathException;
import subway.dto.PathDTO;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class TimeGraph {
    public static WeightedMultigraph<Station, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);
    public static DijkstraShortestPath dijkstraShortestPath;

    public static void addVertex(Station station) {
        graph.addVertex(station);
    }

    private static void setEdgeWeitght(Station stationFrom, Station stationTo, int weight) {
        graph.setEdgeWeight(graph.addEdge(stationFrom, stationTo), weight);
    }

    private static void updateShortestPath() {
        dijkstraShortestPath = new DijkstraShortestPath(graph);
    }

    public static void addSectionToGraph(Section section) {
        Iterator<Station> iterator = section.stationsSet().iterator();
        Station from = iterator.next();
        Station to = iterator.next();

        addVertex(from);
        addVertex(to);

        setEdgeWeitght(from, to, section.getTime());
        updateShortestPath();
    }

    public static PathDTO getShortestPath(Station from, Station to) {
        GraphPath<Station, DefaultWeightedEdge> graphPath = dijkstraShortestPath.getPath(from, to);
        if (graphPath == null) {
            throw new NoConnectionPathException();
        }

        List<String> stationsName = graphPath.getVertexList().stream()
                .map(Station::getName)
                .collect(Collectors.toList());
        double time = graphPath.getWeight();

        return new PathDTO(stationsName, time, getDistance(stationsName));  //0는 개발 과정에서 시험용으로 넣은 것입니다. 이후 거리를 구해서 다시 넣습니다.
    }

    public static int getDistance(List<String> staionsNames) {
        Iterator<String> iterator = staionsNames.iterator();
        int total = 0;
        String from = iterator.next();
        String to = iterator.next();
        try {
            do {
                total += SectionRepository.getDistanceWeightByStationName(from, to);
                from = to;
                to = iterator.next();
            } while (true);
        } catch (Exception e) {
        }
        return total;
    }
}
