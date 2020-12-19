package subway.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class InputValidator {

    private List<String> mainList = Arrays.asList("1", "Q");
    private List<String> pathList = Arrays.asList("1", "2", "B");

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
        Optional<Station> searchedStation = StationRepository.stations()
                .stream().filter(station1 -> station1.getName().equals(station))
                .findAny();
        if (searchedStation.isPresent()) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.isNotStation());
    }
}
