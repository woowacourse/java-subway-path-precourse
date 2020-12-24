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
        int minTime = getPathTime(shortestDistancePath);
        int minDistance = getPathDistance(shortestTimePath);
        printResult(shortestDistancePath, minTime, minDistance);
    }

    public void runToGetMinTime() {
        getStationNames();
        List<String> shortestTimePath = getShortestTimePath();
        int minTime = getPathTime(shortestTimePath);
        int minDistance = getPathDistance(shortestTimePath);
        printResult(shortestTimePath, minTime, minDistance);
    }

    private void printResult(List<String> shortestPath, int minTime, int minDistance) {
        OutputView.printResult(shortestPath, minTime, minDistance);
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

    public int getPathTime(List<String> paths) {
        int timeSum = 0;
        for (int i = 0; i < paths.size()-1 ; i++) {
            String departureStation = paths.get(i);
            String arrivalStation = paths.get(i+1);
            timeSum += getSectionCost(departureStation, arrivalStation).getTimeCost();
        }
        return timeSum;
    }

    private int getPathDistance(List<String> shortestTimePath) {
    }

    private Cost getSectionCost(String departureStation, String arrivalStation) {
        return DefaultSections.getSectionCost(departureStation, arrivalStation);
    }
}
