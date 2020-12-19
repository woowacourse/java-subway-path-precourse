package subway.domain;

import java.util.Arrays;
import java.util.List;

public class InputValidator {

    private List<String> mainList = Arrays.asList("1", "Q");
    private List<String> pathList = Arrays.asList("1", "2", "Q");

    public void checkMain(String mainInput) {
        if (mainList.contains(mainInput)) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.isNotFunction());
    }

    public void checkPath(String pathInput) {
        if (pathList.contains(pathInput)) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.isNotFunction());
    }

    public void checkStation(String station) {
        if (StationRepository.stations().contains(station)) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.isNotStation());
    }
}
