package subway.exception.validation;

import subway.domain.StationRepository;
import subway.exception.SubwayCustomException;
import subway.view.InputView;
import subway.view.OutputView;

public class StationInputValidation {

    private static final String NO_STATION_ERROR = "입력하신 역은 존재하지 않습니다.";

    private final InputView inputView;

    public StationInputValidation(InputView inputView) {
        this.inputView = inputView;
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

    private boolean isNotIncluded(String station) {
        return !StationRepository.contains(station);
    }
}
