package subway.controller;

import subway.domain.graph.SubwayMap;
import subway.domain.line.LineRepository;
import subway.domain.station.StationRepository;
import subway.utils.exception.*;
import subway.view.InputView;
import subway.view.output.RouteOutputView;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RouteFunction {
    private RouteOutputView routeOutputView;


    public RouteFunction(RouteOutputView routeOutputView) {
        this.routeOutputView = routeOutputView;
    }

    public void shortestDistance() {
        try {
            List<String> inputStations = inputStation();
            int distance = SubwayMap.findShortestDistance(inputStations);
            List<String> paths = SubwayMap.findShortestDistancePath(inputStations);
        } catch (NullPointerException e) {
            return;
        }
    }

    private String findLine(List<String> inputStations) {
        return LineRepository.findSelectLine(
                inputStations.get(StationRepository.FIRST_STATION_INDEX), inputStations.get(StationRepository.LAST_STATION_INDEX));
    }

    private List<String> inputStation() {
        try {
            String firstStation = inputFirstStation();
            String lastStation = inputLastStation();
            isSameStation(firstStation, lastStation);
            isValidLine(firstStation, lastStation);
            return Arrays.asList(firstStation, lastStation);
        } catch (NullPointerException | DuplicateStationException e) {
            throw new NullPointerException();
        }
    }

    private void isValidLine(String firstStation, String lastStation) {
        try {
            LineRepository.sameLine(firstStation, lastStation);
            LineRepository.invalidSequence(firstStation, lastStation);
        } catch (NotSameLineException | InvalidSequnceLineException e) {
            throw new NullPointerException();
        }
    }

    private void isSameStation(String firstStation, String lastStation) {
        if (Objects.equals(firstStation, lastStation)) {
            throw new DuplicateStationException();
        }
    }

    private String inputFirstStation() {
        try {
            routeOutputView.printFirstStation();
            String firstStation = InputView.inputStation();
            StationRepository.isExist(firstStation);
            return firstStation;
        } catch (InvalidStationNameException | NotExistStationException e) {
            throw new NullPointerException();
        }
    }

    private String inputLastStation() {
        try {
            routeOutputView.printLastStation();
            String lastStation = InputView.inputStation();
            StationRepository.isExist(lastStation);
            return lastStation;
        } catch (InvalidStationNameException | NotExistStationException e) {
            throw new NullPointerException();
        }
    }

    public void shortestTime() {
        System.out.println("최단 시간\n");
    }
}
