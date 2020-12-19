package subway.domain.path;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;

import subway.domain.weight.WeightType;

public class ShortestPath {
    private DijkstraShortestPath path;
    private WeightType type;

    public ShortestPath(WeightType type) {
        this.path = ShortestPathFactory.getShortestPath(type);
        this.type = type;
    }
}
