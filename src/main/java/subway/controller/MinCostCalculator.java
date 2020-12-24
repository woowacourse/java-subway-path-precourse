package subway.controller;

import java.util.List;
import subway.domain.DefaultSubwayGraph;
import subway.view.InputView;
import subway.view.OutputView;

public class MinCostCalculator {

    private static final String SAME_STATION_ERROR = "출발역과 도착역은 달라야합니다";
    private static final String ERROR_PREFIX = "[ERROR]: ";
    private String departureStation;
    private String arrivalStation;
    private DefaultSubwayGraph defaultSubwayGraph = new DefaultSubwayGraph();

    public void runToGetMinDistance() {
        getStationNames();
        List<String> result = calculateMinDistance();
        printResult(result);
    }

    public void runToGetMinTime() {
        getStationNames();
        List<String> result = calculateMinTime();
        printResult(result);
    }

    private void printResult(List<String> result) {
        OutputView.printResult(result);
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

    public List<String> calculateMinDistance() {
        return defaultSubwayGraph.getDijkstraDistanceShortestPath(departureStation, arrivalStation);
    }

    public List<String> calculateMinTime() {
        return defaultSubwayGraph.getDijkstraDistanceShortestPath(departureStation, arrivalStation);
    }
}
