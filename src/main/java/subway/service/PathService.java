package subway.service;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.exception.StationNotFoundException;
import subway.view.InputView;

public class PathService {

    private PathService() {}

    public static void calculateShortDistance() {
        Station startStation = initStation(InputView.PLEASE_INPUT_START_STATION);
    }

    private static Station initStation(String message) {
        return StationRepository.findByName(InputView.print(message))
            .orElseThrow(StationNotFoundException::new);
    }
}
