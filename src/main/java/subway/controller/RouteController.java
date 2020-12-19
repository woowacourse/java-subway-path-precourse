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

    public static void promptRouteByDistance() {
        OutputView.showPrompt(DEPARTURE_STATION);
        Station departStation = StationRepository.findStationByName(InputView.getInput());
        OutputView.showPrompt(ARRIVAL_STATION);
        Station arrivalStation = StationRepository.findStationByName(InputView.getInput());

        if (departStation.equals(arrivalStation)) {
            throw new TransitRouteException(String.format(SAME_STATION_ERROR_MESSAGE, DEPARTURE_STATION,
                    ARRIVAL_STATION));
        }

        showRouteByDistance(departStation.getName(), arrivalStation.getName());

    }

    public static void showRouteByDistance(String departStation, String arrivalStation){
        List<String> shortestPath = GraphByDistance.getShortestPathByDistance(departStation, arrivalStation);
        int shortestPathDistance = GraphByDistance.getDistanceOfShortestPathByDistance(departStation, arrivalStation);
        int timeOfShortestPathDistance = GraphByDistance.getTimeOfShortestPathByDistance(departStation, arrivalStation);
        OutputView.lookUpResult(shortestPathDistance, timeOfShortestPathDistance, shortestPath);
    }

    public static void promptRouteByTime() {
        OutputView.showPrompt(DEPARTURE_STATION);
        Station departStation = StationRepository.findStationByName(InputView.getInput());
        OutputView.showPrompt(ARRIVAL_STATION);
        Station arrivalStation = StationRepository.findStationByName(InputView.getInput());

        if (departStation.equals(arrivalStation)) {
            throw new TransitRouteException(String.format(SAME_STATION_ERROR_MESSAGE, DEPARTURE_STATION,
                    ARRIVAL_STATION));
        }

        showRouteByTime(departStation.getName(), arrivalStation.getName());
    }

    public static void showRouteByTime(String departStation, String arrivalStation) {
        List<String> shortestPath = GraphByTime.getShortestPathByTime(departStation, arrivalStation);
        int shortestPathTime = GraphByTime.getTimeOfShortestPathByTime(departStation, arrivalStation);
        int distanceOfShortestPathTime = GraphByTime.getDistanceOfShortestPathByTime(departStation, arrivalStation);
        OutputView.lookUpResult(distanceOfShortestPathTime, shortestPathTime, shortestPath);
    }

    /*
    비어있는 메서드, 메서드가 실행되면 이 전의 화면으로 돌아간다.
     */
    public static void back() {

    }
}
