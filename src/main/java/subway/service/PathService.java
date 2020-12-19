package subway.service;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.exception.SectionStationDuplicateException;
import subway.exception.StationNotFoundException;
import subway.view.InputView;

public class PathService {

    private PathService() {}

    public static void calculateShortDistance() {
        Station startStation = initStation(InputView.PLEASE_INPUT_START_STATION);
        Station endStation = initStation(InputView.PLEASE_INPUT_END_STATION);

        validateStationDuplicated(startStation, endStation);
        validatePathSections(startStation, endStation);
    }

    private static Station initStation(String message) {
        return StationRepository.findByName(InputView.print(message))
                .orElseThrow(StationNotFoundException::new);
    }

    private static void validateStationDuplicated(Station startStation, Station endStation) {
        if (startStation.equals(endStation)) {
            throw new SectionStationDuplicateException();
        }
    }

    private static void validatePathSections(Station startStation, Station endStation) {

    }
}
