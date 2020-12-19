package subway.Controller;

import java.util.List;
import java.util.Scanner;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.Views.MainView;
import subway.Views.OutputView;
import subway.domain.DistanceWeightRepository;

public class MinDistanceCalculator {

    public static void calculateMinDistance(Scanner scanner) {
        String startStation = MainView.printStartStation(scanner);
        String endStation = MainView.printEndStation(scanner, startStation);

        List<String> result = DistanceWeightRepository
            .getDijkstraShortestPath(startStation, endStation);
        MainView.printResultScreen(scanner, result);
    }
}
