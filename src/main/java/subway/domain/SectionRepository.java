package subway.domain;

import java.util.ArrayList;
import java.util.List;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class SectionRepository {

    private static final List<Section> sections = new ArrayList<>();
    private static final WeightedMultigraph<Station, DefaultWeightedEdge> distanceGraph = new WeightedMultigraph(DefaultWeightedEdge.class);
    private static final WeightedMultigraph<Station, DefaultWeightedEdge> timeGraph = new WeightedMultigraph(DefaultWeightedEdge.class);

    public static void addSection(Station start, Station end, long distance, long time) {
        Section section = new Section(start, end, distance, time);
        setDistanceGraph(section);
        setTimeGraph(section);
    }

    private static void setDistanceGraph(Section section) {
        distanceGraph.addVertex(section.getStart());
        distanceGraph.addVertex(section.getEnd());
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(section.getStart(), section.getEnd()), section.getDistance());
    }

    private static void setTimeGraph(Section section) {
        timeGraph.addVertex(section.getStart());
        timeGraph.addVertex(section.getEnd());
        timeGraph.setEdgeWeight(timeGraph.addEdge(section.getStart(), section.getEnd()), section.getTime());
    }

    public static Section findByStartAndEndStation(Station start, Station end) {
        return sections.stream()
            .filter(section -> {
                if (section.getStart().getName().equals(start.getName())
                    && section.getEnd().getName().equals(end.getName())) {
                    return true;
                }
                return false;
            })
            .findAny()
            .orElseThrow(() -> {throw new SecurityException();});
    }
}
