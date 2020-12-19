package subway.service;

import subway.domain.Station;
import subway.exception.InputException;
import subway.utils.DijkstraUtils;
import subway.view.InputView;
import subway.view.OutputView;

public class RouteService {

    public static final String SAME_SOURCE_AND_TARGET = "출발역과 도착역이 동일합니다.";
    Station departureStation;
    Station arrivalStation;

    public void retrieveByShortestDistance() {
        init();
        OutputView.printRoute(DijkstraUtils.retrieveByDistance(departureStation, arrivalStation));
    }

    public void retrieveByShortestTime() {
        init();
        OutputView.printRoute(DijkstraUtils.retrieveByTime(departureStation, arrivalStation));
    }

    private void init() {
        departureStation = InputView.getDepartureStation();
        arrivalStation = InputView.getArrivalStation();
        if (departureStation.getName().equals(arrivalStation.getName())) {
            throw new InputException(SAME_SOURCE_AND_TARGET);
        }
    }
}
