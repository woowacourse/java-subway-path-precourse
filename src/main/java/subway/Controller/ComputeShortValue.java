package subway.Controller;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import subway.domain.Line;
import subway.domain.LineRepository;

import java.util.List;

public class ComputeShortValue {
    List<Line> allLine=LineRepository.lines();
    WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);

}
