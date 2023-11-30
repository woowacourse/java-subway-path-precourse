package subway.domain;

import org.jgrapht.GraphPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import subway.domain.pathFinder.DistancePathFinder;
import subway.domain.pathFinder.StationPathFinder;
import subway.domain.pathFinder.TimePathFinder;
import subway.domain.repository.PathRepository;

public class SubwayService {
    private static final StationPathFinder timePathFinder = new TimePathFinder();
    private static final StationPathFinder distanceFinder = new DistancePathFinder();


    public PathResult findShortestPath(Station start, Station end) {
        GraphPath<Station, DefaultWeightedEdge> path = findPath(distanceFinder, start, end);
        int time = PathRepository.getTotalTime(path.getVertexList());
        return new PathResult(path.getVertexList(), time, (int)path.getWeight());
    }

    public PathResult findFastestPath(Station start, Station end) {
        GraphPath<Station, DefaultWeightedEdge> path = findPath(timePathFinder, start, end);
        int distance = PathRepository.getTotalDistance(path.getVertexList());
        return new PathResult(path.getVertexList(), distance, (int) path.getWeight());
    }
    private GraphPath<Station, DefaultWeightedEdge> findPath(StationPathFinder pathFinder, Station start, Station end) {
        return pathFinder.findPath(start, end);
    }

}
