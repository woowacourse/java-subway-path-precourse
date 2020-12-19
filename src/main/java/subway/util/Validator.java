package subway.util;

import subway.domain.StationRepository;
import subway.view.OutputView;

import java.util.List;

public class Validator {

    public static void functionSelect(final List<String> choices, final String command) {
        if (!choices.contains(command)) {
            OutputView.printError(OutputView.ERROR_INVALID_SELECT);
            throw new IllegalArgumentException();
        }
    }

    public static void existStation(final String stationName) {
        if (!StationRepository.isExist(stationName)){
            OutputView.printError(OutputView.ERROR_INVALID_STATION);
            throw new IllegalArgumentException();
        }
    }

    public static boolean sameStation(final String source, final String destination) {
        if (source.equals(destination)) {
            OutputView.printError(OutputView.ERROR_SAME_STATION);
            return true;
        }
        return false;
    }

    public static boolean unconnected(final String source, final String destination) {
        // 구현 못했습니다.
        return false;
    }

}
