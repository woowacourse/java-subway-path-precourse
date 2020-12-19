package subway.controller;

import subway.domain.GraphByDistance;
import subway.domain.GraphByTime;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.exception.TransitRouteException;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;


public class RouteController {
    private static final String DEPARTURE_STATION = "출발역";
    private static final String ARRIVAL_STATION = "도착역";
    private static final String SAME_STATION_ERROR_MESSAGE = "%s과 %s이 동일합니다.";

    public static void showRouteByDistance() {
        OutputView.showPrompt(DEPARTURE_STATION);
        Station departStation = StationRepository.findStationByName(InputView.getInput());
        OutputView.showPrompt(ARRIVAL_STATION);
        Station arrivalStation = StationRepository.findStationByName(InputView.getInput());
        if (departStation.equals(arrivalStation)) {
            throw new TransitRouteException(String.format(SAME_STATION_ERROR_MESSAGE, DEPARTURE_STATION,
                    ARRIVAL_STATION));
        }
        List<String> shortestPath = GraphByDistance.getShortestPathByDistance(departStation.getName(),
                arrivalStation.getName());
        int shortestPathDistance = GraphByDistance.getDistanceOfShortestPathByDistance(departStation.getName(),
                arrivalStation.getName());
        int timeOfShortestPathDistance = GraphByDistance.getTimeOfShortestPathByDistance(departStation.getName(),
                arrivalStation.getName());
        OutputView.lookUpResult(shortestPathDistance, timeOfShortestPathDistance, shortestPath);
    }

    public static void showRouteByTime() {
        OutputView.showPrompt(DEPARTURE_STATION);
        Station departStation = StationRepository.findStationByName(InputView.getInput());
        OutputView.showPrompt(ARRIVAL_STATION);
        Station arrivalStation = StationRepository.findStationByName(InputView.getInput());
        if (departStation.equals(arrivalStation)) {
            throw new TransitRouteException(String.format(SAME_STATION_ERROR_MESSAGE, DEPARTURE_STATION,
                    ARRIVAL_STATION));
        }
        List<String> shortestPath = GraphByTime.getShortestPathByTime(departStation.getName(),
                arrivalStation.getName());
        int shortestPathTime = GraphByTime.getTimeOfShortestPathByTime(departStation.getName(),
                arrivalStation.getName());
        int distanceOfShortestPathTime = GraphByTime.getDistanceOfShortestPathByTime(departStation.getName(),
                arrivalStation.getName());
        OutputView.lookUpResult(distanceOfShortestPathTime, shortestPathTime, shortestPath);
    }

    /*
    비어있는 메서드, 메서드가 실행되면 이 전의 화면으로 돌아간다.
     */
    public static void back() {

    }
}
