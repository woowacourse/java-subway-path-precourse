package subway;

import subway.domain.Station;
import subway.domain.StationRepository;

public class RouteSearchService {
    public static void view() {
        OutputView.printRouteSearchView();
        String answer = InputView.getAnswer();
        if (answer.equals("1") || answer.equals("2")) {
            getRoute(answer);
            return;
        }
        if (answer.equals("B")) {
            return;
        }
        throw new IllegalArgumentException("잘못된 입력값입니다.");
    }

    private static void getRoute(String code) {
        OutputView.printStartStationMessage();
        Station start = StationRepository.getStation(InputView.getStation());
        OutputView.printEndStationMessage();
        Station end = StationRepository.getStation(InputView.getStation());
        OutputView.printSearchResult(start, end);
    }

}
