package subway.service;

import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.regex.Pattern;

public class StationService {
    private static final String SPACE = " ";
    private static final String OPEN_BRACKET = "(";
    private static final String CLOSE_BRACKET = ")";
    private static final int MIN_NAME_LENGTH = 2;
    private static final String DUPLICATION_ERROR_MESSAGE = "이미 해당 이름의 역이 존재합니다.";
    private static final String NAME_LETTER_TYPE_ERROR_MESSAGE = "역의 이름은 한글, 숫자만을 포함해야 합니다.";
    private static final String NAME_LENGTH_ERROR_MESSAGE = "역의 이름은 " + MIN_NAME_LENGTH + "글자 이상이여야 합니다.";

    public void addStation(String name) {
        validate(name);
        StationRepository.addStation(new Station(name));
    }

    private void validate(String name) {
        validateExistence(name);
        validateNameLength(name);
        validateNameLetterType(name);
    }

    private void validateExistence(String name) {
        if (StationRepository.isExistent(name)) {
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

    private static String getNameWithBrackets(String name) {
        return SPACE + OPEN_BRACKET + name + CLOSE_BRACKET;
    }
}
