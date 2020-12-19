package subway.controller;

import subway.domain.GraphByDistance;
import subway.domain.GraphByTime;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.exception.TransitRouteException;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;

import static subway.domain.GraphByDistance.getShortestPathDistanceTime;

public class RouteController {

    public static void showRouteByDistance() {
        OutputView.showPrompt("출발역");
        Station departStation = StationRepository.findStationByName(InputView.getInput());
        OutputView.showPrompt("도착역");
        Station arrivalStation = StationRepository.findStationByName(InputView.getInput());
        System.out.println(departStation.getName());
        System.out.println(arrivalStation.getName());
        if (departStation.equals(arrivalStation)) {
            throw new TransitRouteException("출발역과 도착역이 동일합니다.");
        }
        List<String> shortestPath = GraphByDistance.checkShortestPath(departStation.getName(),
                arrivalStation.getName());
        int shortestPathDistance = GraphByDistance.checkShortestPathDistance(departStation.getName(),
                arrivalStation.getName());
        ;
        System.out.println(shortestPath);
        System.out.println(shortestPathDistance);
        System.out.println(getShortestPathDistanceTime(departStation.getName(), arrivalStation.getName()));
    }

    public static void showRouteByTime() {
        OutputView.showPrompt("출발역");
        Station departStation = StationRepository.findStationByName(InputView.getInput());
        OutputView.showPrompt("도착역");
        Station arrivalStation = StationRepository.findStationByName(InputView.getInput());
        if (departStation.equals(arrivalStation)) {
            throw new TransitRouteException("출발역과 도착역이 동일합니다.");
        }
        List<String> shortestPath = GraphByTime.checkShortestPath(departStation.getName(),
                arrivalStation.getName());
        int shortestPathTime = GraphByTime.checkShortestPathTime(departStation.getName(),
                arrivalStation.getName());
        System.out.println(shortestPath);
        System.out.println(shortestPathTime);
    }

    public static void showRoute(){

    }

    /*
    비어있는 메서드, 메서드가 실행되면 이 전의 화면으로 돌아간다.
     */
    public static void back() {

    }
}
