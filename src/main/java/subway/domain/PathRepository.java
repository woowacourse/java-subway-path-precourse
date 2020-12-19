package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PathRepository {
    private static final List<Path> paths = new ArrayList<>();

    public static List<Path> paths(){
        return Collections.unmodifiableList(paths);
    }

    public static void addPath(Path path) {
        paths().add(path);
    }

    public static void getShortestPath(){
        Path shortestPath;
        DijkstraShortestPath dijkstraShortestPath;
        for(Path path : paths){
            dijkstraShortestPath = new DijkstraShortestPath(path.getPathDistanceWeight().getPathDistance());
        }
    }
}
