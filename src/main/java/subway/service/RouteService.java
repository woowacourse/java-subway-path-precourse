package subway.service;

import subway.domain.Station;
import subway.utils.DijkstraUtils;
import subway.view.InputView;
import subway.view.OutputView;

public class RouteService {

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
        // todo 경로 조회 시 출발역과 도착역이 같으면 에러를 출력한다.
    }
}
