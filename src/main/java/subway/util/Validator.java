package subway.util;

import subway.domain.StationRepository;
import subway.menu.MainMenu;
import subway.menu.PathMenu;

import java.util.Arrays;

public class Validator {
    private final String OPTION_NOT_FOUND_WARN = "[ERROR] 선택지 안의 기능을 선택하셔야 합니다.\n";
    private final String STATION_NOT_FOUND_WARN = "[ERROR] 존재하지 않는 역입니다.\n";
    private final String START_STATION_END_STATION_DUPLICATE_WARN = "[ERROR] 출발역과 도착역이 동일해서는 안됩니다.\n";

    protected void validateMainMenuOption(String option) {
        boolean result = Arrays.stream(MainMenu.values())
                .map(MainMenu::getOption)
                .anyMatch(menuOption -> menuOption.equals(option));
        if (!result) {
            throw new IllegalArgumentException(OPTION_NOT_FOUND_WARN);
        }
    }

    protected void validatePathMenuOption(String option) {
        boolean result = Arrays.stream(PathMenu.values())
                .map(PathMenu::getOption)
                .anyMatch(menuOption -> menuOption.equals(option));
        if (!result) {
            throw new IllegalArgumentException(OPTION_NOT_FOUND_WARN);
        }
    }

    protected void validateStartStation(String startStationName) {
        boolean result = StationRepository.stations().stream()
                .anyMatch(station -> station.getName().equals(startStationName));
        if (!result) {
            throw new IllegalArgumentException(STATION_NOT_FOUND_WARN);
        }
    }

    protected void validateEndStation(String endStationName, String startStationName) {
        boolean result = StationRepository.stations().stream()
                .anyMatch(station -> station.getName().equals(endStationName));
        if (!result) {
            throw new IllegalArgumentException(STATION_NOT_FOUND_WARN);
        }
        if (endStationName.equals(startStationName)) {
            throw new IllegalArgumentException(START_STATION_END_STATION_DUPLICATE_WARN);
        }
    }
}
