package subway.controller;

import java.util.List;
import subway.domain.Cost;
import subway.domain.DefaultSections;
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
        List<String> shortestDistancePath = getShortestDistancePath();
        Cost cost = getPathCost(shortestDistancePath);
        printResult(shortestDistancePath, cost);
    }

    public void runToGetMinTime() {
        getStationNames();
        List<String> shortestTimePath = getShortestTimePath();
        Cost cost = getPathCost(shortestTimePath);
        printResult(shortestTimePath, cost);
    }

    private void printResult(List<String> shortestPath, Cost cost) {
        OutputView.printResult(shortestPath, cost);
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

    public List<String> getShortestDistancePath() {
        return defaultSubwayGraph.getDijkstraDistanceShortestPath(departureStation, arrivalStation);
    }

    public List<String> getShortestTimePath() {
        return defaultSubwayGraph.getDijkstraDistanceShortestPath(departureStation, arrivalStation);
    }

    public Cost getPathCost(List<String> paths) {
        Cost cost = new Cost(0, 0);
        for (int i = 0; i < paths.size()-1 ; i++) {
            String departureStation = paths.get(i);
            String arrivalStation = paths.get(i+1);
            cost.addTimeCost(getSectionCost(departureStation, arrivalStation).getTimeCost());
            cost.addDistanceCost(getSectionCost(departureStation, arrivalStation).getDistanceCost());
        }
        return cost;
    }

    private Cost getSectionCost(String departureStation, String arrivalStation) {
        return DefaultSections.getSectionCost(departureStation, arrivalStation);
    }
}
