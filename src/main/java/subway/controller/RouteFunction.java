package subway.controller;

import subway.domain.graph.DistanceGraphRepository;
import subway.domain.station.StationRepository;
import subway.utils.exception.DuplicateStationException;
import subway.utils.exception.InvalidStationNameException;
import subway.utils.exception.NotExistStationException;
import subway.view.InputView;
import subway.view.output.RouteOutputView;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RouteFunction {
    private static final DistanceGraphRepository distanceGraphRepository = new DistanceGraphRepository();
    private static final StationRepository stationRepository = new StationRepository();
    private RouteOutputView routeOutputView;

    public RouteFunction(RouteOutputView routeOutputView) {
        this.routeOutputView = routeOutputView;
    }

    public void shortestDistance() {
        try {
            List<String> inputStations = inputStation();

        } catch (NullPointerException e) {
            return;
        }
    }

    private List<String> inputStation() {
        try {
            String firstStation = inputFirstStation();
            String lastStation =  inputLastStation();
            isSameStation(firstStation, lastStation);
            return Arrays.asList(firstStation, lastStation);
        } catch (InvalidStationNameException | NotExistStationException | DuplicateStationException e) {
            throw new NullPointerException();
        }
    }

    private void isSameStation(String firstStation, String lastStation) {
        if (Objects.equals(firstStation, lastStation)) {
            throw new DuplicateStationException();
        }
    }

    private String inputFirstStation() {
        routeOutputView.printFirstStation();
        String firstStation = InputView.inputStation();
        stationRepository.isExist(firstStation);
        return firstStation;
    }

    private String inputLastStation() {
        routeOutputView.printLastStation();
        String lastStation = InputView.inputStation();
        stationRepository.isExist(lastStation);
        return lastStation;
    }

    public void shortestTime() {
        System.out.println("최단 시간\n");
    }
}
