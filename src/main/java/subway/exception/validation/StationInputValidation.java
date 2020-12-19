package subway.exception.validation;

import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.exception.SubwayCustomException;
import subway.view.InputView;
import subway.view.OutputView;

public class StationInputValidation {

    private static final String NO_STATION_ERROR = "입력하신 역은 존재하지 않습니다.";
    private static final String SAME_STATIONS_ERROR = "경로 조회 시 출발역과 도착역이 같지 않아야 합니다.";
    private static final String NOT_ON_SAME_LINE = "경로 조회 시 출발역과 도착역이 연결돼있어야 합니다.";
    private final InputView inputView;

    public StationInputValidation(InputView inputView) {
        this.inputView = inputView;
    }

    public String[] input() {
        String startStationName = inputStartStation();
        String endStationName = inputEndStation();
        try {
            if (isDuplicated(startStationName, endStationName)) {
                throw new SubwayCustomException(SAME_STATIONS_ERROR);
            }
            if (isNotOnSameLine(startStationName, endStationName)) {
                throw new SubwayCustomException(NOT_ON_SAME_LINE);
            }
            String[] stations = {startStationName, endStationName};
            return stations;
        } catch (SubwayCustomException e) {
            OutputView.printError(e);
            return input();
        }
    }

    public String inputStartStation() {
        String stationName = this.inputView.inputStartStation();
        try {
            if (isNotIncluded(stationName)) {
                throw new SubwayCustomException(NO_STATION_ERROR);
            }
            return stationName;
        } catch (SubwayCustomException e) {
            OutputView.printError(e);
            return inputStartStation();
        }
    }

    public String inputEndStation() {
        String stationName = this.inputView.inputEndStation();
        try {
            if (isNotIncluded(stationName)) {
                throw new SubwayCustomException(NO_STATION_ERROR);
            }
            return stationName;
        } catch (SubwayCustomException e) {
            OutputView.printError(e);
            return inputEndStation();
        }
    }

    public boolean isDuplicated(String startStation, String endStation) {
        return startStation.equals(endStation);
    }

    public boolean isNotOnSameLine(String startStation, String endStation) {
        return !LineRepository.isOnSameLine(startStation, endStation);
    }

    private boolean isNotIncluded(String station) {
        return !StationRepository.contains(station);
    }
}
