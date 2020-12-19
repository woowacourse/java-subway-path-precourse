package subway.path;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.line.Line;
import subway.section.Section;
import subway.section.SectionService;
import subway.section.Sections;
import subway.station.Station;

import java.util.List;

public class PathService {
    private SectionService sectionService;

    public PathService(){
        this.sectionService = new SectionService();
    }

    public List<Station> getMinimumPath(GraphPath path) {
        return path.getVertexList();
    }

    public double getMinimumWeight(GraphPath path) {
        return path.getWeight();
    }

    public GraphPath getDijkstraShortestPath(List<Station> stations, List<Line> lines, Station startStation, Station endStation, String method) {
        WeightedMultigraph<Station, DefaultWeightedEdge> graph = getGraph(stations, lines, method);
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        return dijkstraShortestPath.getPath(startStation, endStation);
    }

    private WeightedMultigraph<Station, DefaultWeightedEdge> getGraph(List<Station> stations, List<Line> lines, String method) {
        WeightedMultigraph<Station, DefaultWeightedEdge> graph
                = new WeightedMultigraph(DefaultWeightedEdge.class);

        for (Station station : stations) {
            graph.addVertex(station);
        }

        for (Line line : lines) {
            Sections sections = line.getSections();
            List<Section> sectionList = sections.getSections();
            addAllEdge(method, graph, sectionList);
        }

        return graph;
    }

    private void addAllEdge(String method, WeightedMultigraph<Station, DefaultWeightedEdge> graph, List<Section> sectionList) {
        for (Section section : sectionList) {
            addEdge(method, graph, section);
        }
    }

    private void addEdge(String method, WeightedMultigraph<Station, DefaultWeightedEdge> graph, Section section) {
        int weight = 0;
        if (method.equals(SearchMethod.DISTANCE.getValue())) {
            weight = section.getDistance();
        }
        if (method.equals(SearchMethod.TIME.getValue())) {
            weight = section.getTime();
        }
        graph.setEdgeWeight(graph.addEdge(section.getStartStation(), section.getEndStation()), weight);
    }

    public int getPathTime(List<Station> shortestPath) {
        int time = 0;
        for (int i = 0; i < shortestPath.size() - 1; i++) {
            Station start = shortestPath.get(i);
            Station end = shortestPath.get(i + 1);
            time += sectionService.getSectionTime(start, end);
        }
        return time;
    }

    public int getPathDistance(List<Station> shortestPath) {
        int distance = 0;
        for (int i = 0; i < shortestPath.size() - 1; i++) {
            Station start = shortestPath.get(i);
            Station end = shortestPath.get(i + 1);
            distance += sectionService.getSectionDistance(start, end);
        }
        return distance;
    }
}
