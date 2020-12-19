package subway.service;

import subway.domain.EdgeRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.SubwayGraph;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;

public class RouteSearchService {
    public static final String SHORTEST_DISTANCE_CODE = "1";
    public static final String SHORTEST_ELAPSED_TIME_CODE = "2";
    public static final String BACK_TO_MAIN_CODE = "B";
    public static final String ERR_SAME_FROM_TO_STATION = "출발역과 도착역이 동일합니다.";
    public static final String ERR_IMPROPER_INPUT_CODE = "잘못된 입력값입니다.";

    public static void main() {
        try {
            view();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            main();
        }
    }

    public static void view() {
        OutputView.printRouteSearchView();
        String code = InputView.getAnswer();
        if (code.equals(SHORTEST_DISTANCE_CODE)) {

            getShortestDistanceRoute();
            return;
        }
        if (code.equals(SHORTEST_ELAPSED_TIME_CODE)) {
            getShortestTimeRoute();
            return;
        }
        if (code.equals(BACK_TO_MAIN_CODE)) {
            return;
        }
        throw new IllegalArgumentException(ERR_IMPROPER_INPUT_CODE);
    }

    private static void getShortestDistanceRoute() {
        Station from = getStationFrom();
        Station to = getStationTo();
        validateNotSameStation(from, to);
        printResult(SubwayGraph.getDistanceShortestPath(from, to));
    }

    private static void getShortestTimeRoute() {
        Station from = getStationFrom();
        Station to = getStationTo();
        validateNotSameStation(from, to);
        printResult(SubwayGraph.getTimeShortestPath(from, to));
    }

    private static void printResult(List<Station> stations) {
        int routeLength = EdgeRepository.getRouteLength(stations);
        int elapsedTime = EdgeRepository.getElapsedTime(stations);
        OutputView.printSearchResult(routeLength, elapsedTime, stations);
    }

    private static Station getStationFrom() {
        OutputView.printFromStationMessage();
        return StationRepository.getStation(InputView.getStation());
    }

    private static Station getStationTo() {
        OutputView.printToStationMessage();
        return StationRepository.getStation(InputView.getStation());
    }

    private static void validateNotSameStation(Station from, Station to) {
        if (from.equals(to)) {
            throw new IllegalArgumentException(ERR_SAME_FROM_TO_STATION);
        }
    }
}
