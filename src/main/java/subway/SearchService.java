package subway;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;

import java.util.ArrayList;
import java.util.List;

public class SearchService {
    private static final List<DijkstraShortestPath> dijkstraShortestPaths = new ArrayList<>();

    public SearchService() {
    }

    public static void addDijkstraShortestPath(DijkstraShortestPath dijkstraShortestPath) {
        dijkstraShortestPaths.add(dijkstraShortestPath);
    }
}
