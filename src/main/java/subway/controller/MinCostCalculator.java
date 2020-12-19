package subway.controller;

import java.util.List;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import subway.domain.DefaultLines;
import subway.domain.DefaultSections;
import subway.domain.DefaultStations;
import subway.domain.DefaultSubwayGraph;
import subway.domain.Line;
import subway.domain.Station;
import subway.view.InputView;

public class MinCostCalculator {

    private static final String SAME_STATION_ERROR = "출발역과 도착역은 달라야합니다";
    private static final String ERROR_PREFIX = "[ERROR]: ";
    private String departureStation;
    private String arrivalStation;
    private DefaultSubwayGraph defaultSubwayGraph = new DefaultSubwayGraph();

    public void runToGetMinDistance() {
        getStationNames();
        calculateMinDistance();
//        printResult();
    }

    public void runToGetMinTime() {
        getStationNames();
        calculateMinTime();
//        printResult();
    }

    private void getStationNames() {
        try {
            departureStation = InputView.inputDepartureStation();
            arrivalStation = InputView.inputArrivalStation();
            if (departureStation.equals(arrivalStation)) {
                throw new IllegalArgumentException(SAME_STATION_ERROR);
            }
        } catch (Exception e) {
            System.out.println(ERROR_PREFIX + e.getMessage());
            getStationNames();
        }
    }

    public void calculateMinDistance() {
        DefaultSubwayGraph defaultSubwayGraph = new DefaultSubwayGraph();
//        List shortest_path = (List) DijkstraShortestPath
//            .findPathBetween(defaultSubwayGraph, departureStation, arrivalStation);
//        System.out.println(shortest_path);
//        DefaultSections defaultSections = new DefaultSections();
//        System.out.println(defaultSections.getSections());

    }

    public void calculateMinTime() {
    }
}
