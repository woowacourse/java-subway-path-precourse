package subway.domain.section;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;

public class SectionWithTimeRepository {
    private WeightedMultigraph<String, DefaultWeightedEdge> sectionsWithTime
            = new WeightedMultigraph(DefaultWeightedEdge.class);

    public void save(String from, String to, DistanceAndTime distanceAndTime) {
        saveVertex(from, to);
        saveTime(from, to, distanceAndTime);
    }

    public SectionsAndTime find(String from, String to) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(sectionsWithTime);
        List<String> sections = dijkstraShortestPath.getPath(from, to).getVertexList();
        double time = dijkstraShortestPath.getPath(from, to).getWeight();

        return new SectionsAndTime(sections, time);
    }

    private void saveVertex(String from, String to) {
        sectionsWithTime.addVertex(from);
        sectionsWithTime.addVertex(to);
    }

    private void saveTime(String from, String to, Time time) {
        sectionsWithTime.setEdgeWeight(
                sectionsWithTime.addEdge(from, to), time.getTime());
    }



}
