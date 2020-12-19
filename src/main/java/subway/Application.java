package subway;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.WeightedMultigraph;
import subway.controller.SearchController;
import subway.domain.*;

import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        SubwayPathApp app = new SubwayPathApp(scanner);
        app.run();
    }
}
