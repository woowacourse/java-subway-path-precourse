package subway.controller;

import java.util.List;
import subway.domain.searcher.DistancePathSearcher;
import subway.domain.searcher.TimePathSearcher;
import subway.domain.section.Distance;
import subway.domain.section.ResultDto;
import subway.domain.section.Time;
import subway.domain.station.Station;
import subway.repository.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayPathController {

    private final InputView inputView = InputView.getInstance();
    private final StationRepository stationRepository = new StationRepository();
    private final TimePathSearcher timePathSearcher = new TimePathSearcher();
    private final DistancePathSearcher distancePathSearcher = new DistancePathSearcher();

    public void findByTime() {
        Station from = inputStartStation();
        Station to = inputEndStation();

        validateStations(from, to);
        List<Station> route = findRouteByTime(from, to);

        ResultDto result = calculateResult(route);

        OutputView.printResult(route, result);
    }

    public void findByDistance() {
        Station from = inputStartStation();
        Station to = inputEndStation();

        validateStations(from, to);
        List<Station> route = findByRouteByDistance(from, to);

        ResultDto result = calculateResult(route);
        OutputView.printResult(route, result);

    }


    private ResultDto calculateResult(List<Station> route) {
        /*
         *  미구현..
         * */
        return ResultDto.create(Time.of(10), Distance.of(10));
    }

    private List<Station> findRouteByTime(Station from, Station to) {
        return timePathSearcher.getTotalRoute(from, to);
    }

    private List<Station> findByRouteByDistance(Station from, Station to) {
        return distancePathSearcher.getTotalRoute(from, to);
    }


    private Station inputStartStation() {
        String startName = inputView.inputStartStation();
        return stationRepository.findByName(startName);
    }

    private Station inputEndStation() {
        String startName = inputView.inputStartStation();
        return stationRepository.findByName(startName);
    }

    private void validateStations(Station start, Station end) {
        if (start.equals(end)) {
            throw new IllegalArgumentException("[ERROR] 출발역과 도착역이 동일합니다.");
        }
    }

}
