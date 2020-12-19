package subway.controller;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.GraphRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;

import java.util.List;
import java.util.Scanner;

public class SearchController {
    private final Scanner scanner;

    public SearchController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void searchByDistance() {
        Station from = getDeparture();
        Station to = getArrival();
        // TODO :: 최단 거리 계산
    }

    private Station getDeparture() {
        String name = InputView.getDepartureStation(scanner);
        return getStationByName(name);
    }

    private Station getArrival() {
        String name = InputView.getDepartureStation(scanner);
        return getStationByName(name);
    }

    private Station getStationByName(String name) {
        return StationRepository.getStation(name);
    }
}
