package subway.service;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.StationRepository;

import java.util.List;
import java.util.regex.Pattern;

public class LineService {
    private static final String SPACE = " ";
    private static final String OPEN_BRACKET = "(";
    private static final String CLOSE_BRACKET = ")";
    private static final int MIN_NAME_LENGTH = 2;
    private static final String DUPLICATION_ERROR_MESSAGE = "이미 해당 이름의 노선이 존재합니다.";
    private static final String NAME_LETTER_TYPE_ERROR_MESSAGE = "노선의 이름은 한글, 숫자만을 포함해야 합니다.";
    private static final String NAME_LENGTH_ERROR_MESSAGE = "노선의 이름은 " + MIN_NAME_LENGTH + "글자 이상이여야 합니다.";
    private static final String STATION_NON_EXISTENT_ERROR_MESSAGE = "해당 역은 존재하지 않습니다.";

    public void addLine(String name, List<String> stationNames) {
        validate(name, stationNames);
        LineRepository.addLine(new Line(name));
        addStations(name, stationNames);
    }

    private void addStations(String name, List<String> stationNames) {
        stationNames.stream()
                .map(StationRepository::selectByName)
                .forEach(station -> LineRepository.addStation(name, station));
    }

    private void validate(String name, List<String> stationNames) {
        validateExistence(name);
        validateNameLength(name);
        validateNameLetterType(name);
        validateStations(stationNames);
    }

    private void validateExistence(String name) {
        if (LineRepository.isExistent(name)) {
            throw new IllegalArgumentException(DUPLICATION_ERROR_MESSAGE);
        }
    }

    private static void validateNameLength(String name) {
        if (name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE + getNameWithBrackets(name));
        }
    }

    private static void validateNameLetterType(String name) {
        String regex = "^[0-9가-힣]*$";
        if (!Pattern.matches(regex, name)) {
            throw new IllegalArgumentException(NAME_LETTER_TYPE_ERROR_MESSAGE + getNameWithBrackets(name));
        }
    }

    private void validateStations(List<String> stationNames) {
        for (String stationName : stationNames) {
            if (!StationRepository.isExistent(stationName)) {
                throw new IllegalArgumentException(STATION_NON_EXISTENT_ERROR_MESSAGE + getNameWithBrackets(stationName));
            }
        }
    }

    private static String getNameWithBrackets(String name) {
        return SPACE + OPEN_BRACKET + name + CLOSE_BRACKET;
    }
}
