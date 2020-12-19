package subway.controller;

import subway.domain.graph.DistanceGraphRepository;
import subway.domain.station.StationRepository;
import subway.utils.exception.InvalidStationNameException;
import subway.utils.exception.NotExistStationException;
import subway.view.InputView;
import subway.view.output.RouteOutputView;

import java.util.Arrays;
import java.util.List;

public class RouteFunction {
    private static final DistanceGraphRepository distanceGraphRepository = new DistanceGraphRepository();
    private static final StationRepository stationRepository = new StationRepository();
    private RouteOutputView routeOutputView;

    public RouteFunction(RouteOutputView outeOutputView) {
        this.routeOutputView = outeOutputView;
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

            return Arrays.asList(firstStation, lastStation);
        } catch (InvalidStationNameException | NotExistStationException e) {
            throw new NullPointerException();
        }
    }

    private String inputFirstStation() {
        routeOutputView.printFirstStation();
        String firstStation = inputFirstStation();
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
