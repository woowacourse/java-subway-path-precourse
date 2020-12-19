package subway.domain.section;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.exception.StationNotConnectedException;

import java.util.List;

public class SectionWithDistanceRepository {
    private WeightedMultigraph<String, DefaultWeightedEdge> sectionsWithDistance
            = new WeightedMultigraph(DefaultWeightedEdge.class);

    public void save(String from, String to, DistanceAndTime distanceAndTime) {
        saveVertex(from, to);
        saveDistance(from, to, distanceAndTime);
    }

    public SectionsAndDistance find(String from, String to) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(sectionsWithDistance);
        List<String> sections = dijkstraShortestPath.getPath(from, to).getVertexList();

        double distance;
        try {
            distance = dijkstraShortestPath.getPath(from, to).getWeight();
        } catch (NullPointerException e) {
            throw new StationNotConnectedException();
        }

        return new SectionsAndDistance(sections, distance);
    }

    private void saveVertex(String from, String to) {
        if(!sectionsWithDistance.containsVertex(to)) {
            sectionsWithDistance.addVertex(from);
        }

        if(!sectionsWithDistance.containsVertex(to)) {
            sectionsWithDistance.addVertex(to);
        }
    }


    private void saveDistance(String from, String to, Distance distance) {
        sectionsWithDistance.setEdgeWeight(
                sectionsWithDistance.addEdge(from, to), distance.getDistance());
    }
}
